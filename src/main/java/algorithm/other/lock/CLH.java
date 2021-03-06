package algorithm.other.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Craig, Landin, and Hagersten
 * 适合SMP(Symmetric Multi-Processor)架构
 * 仅供学习
 */
public class CLH {
    private final ThreadLocal<Node> pre = ThreadLocal.withInitial(() -> null);//此结点并未使用，标准实现中此结点是为了后续可以取消而建立
    private final ThreadLocal<Node> node = ThreadLocal.withInitial(Node::new);
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    private static class Node {
        private volatile boolean locked;
    }

    public void lock() {
        final Node node = this.node.get();
        node.locked = true;//上锁后 供后续结点使用
        Node pre = this.tail.getAndSet(node);//获取上一结点，如果之前并未使用过，此结点为空结点，也就是说上一结点并未上锁
        this.pre.set(pre);//并未使用
        while (pre.locked) ;//等待上一结点释放
    }

    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
        this.node.set(this.pre.get());//并未使用
    }

}
