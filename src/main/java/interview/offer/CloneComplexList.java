package interview.offer;

public class CloneComplexList {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        RandomListNode origin = pHead;
        while (null!=origin){
            RandomListNode add = new RandomListNode(origin.label);
            add.next = origin.next;
            origin.next = add;
            origin = add.next;

        }
        origin = pHead;

        while (null!=origin){
            if (origin.random != null) {
                origin.next.random = origin.random.next;
            }
            origin = origin.next.next;
        }
        origin = pHead;
        RandomListNode head = new RandomListNode(-1);
        RandomListNode current = head;
        while (null!=origin){
            current.next = origin.next;
            current = current.next;
            if (origin.next != null) {
                origin.next = origin.next.next;//还原原始链表
            }
            origin = origin.next;
        }
        return head.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
