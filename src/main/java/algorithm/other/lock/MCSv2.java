package algorithm.other.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * John Mellor-Crummey and Michael Scott
 * 适合NUMA(Non-Uniform Memory Access)架构
 *
 * MCS算法的改进版本，此版本使用LockSupport代替自旋，
 * 从性能上来说提升了5倍不止，而且cpu占用也明显下降
 * 此版本好像不适合NUMA架构？
 */
public class MCSv2 {
    AtomicReference<Node> tail = new AtomicReference<>();
    ThreadLocal<Node> node = ThreadLocal.withInitial(Node::new);

    //    AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(MCS.class,Node.class,"tail");
    public void lock() {
        Node n = node.get();
        n.thread = Thread.currentThread();
        Node pre = tail.getAndSet(n);
        if (pre == null) {
            n.locked = false;
        } else {
            pre.next = n;
            if (n.locked){
                //本结点让出cpu,等待上一结点通知获取锁，可以不用再加if判断，
                // 如果执行到此步时上一结点已经执行unpark,此时再park会立即放行不会block
                LockSupport.park();

            }
        }
    }

    public void unlock() {
        Node n = node.get();
        node.remove();
        if (n.next == null) {
            if (tail.compareAndSet(n, null)) {
                return;
            }
        }
        n.next.locked = false;
        LockSupport.unpark(n.next.thread);//唤醒下一结点
        n.next = null;//断开连接
    }


    class Node {
        volatile boolean locked = true;
        volatile Node next = null;
        volatile Thread thread = null;
    }
}
