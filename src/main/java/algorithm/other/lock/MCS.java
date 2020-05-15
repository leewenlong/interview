package algorithm.other.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * John Mellor-Crummey and Michael Scott
 * 适合NUMA(Non-Uniform Memory Access)架构
 * 仅供学习
 */
public class MCS {
    AtomicReference<Node> tail = new AtomicReference<>();
    ThreadLocal<Node> node = ThreadLocal.withInitial(Node::new);

    //    AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(MCS.class,Node.class,"tail");
    public void lock() {
        Node n = node.get();
        Node pre = tail.getAndSet(n);
        if (pre == null) {
            n.locked = false;
        } else {
            pre.next = n;
            while (n.locked) ;//等待上一结点通知获取锁
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
        n.next = null;//断开连接
    }

    class Node {
        volatile boolean locked = true;
        volatile Node next = null;
    }
}
