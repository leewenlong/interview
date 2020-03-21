package interview.offer;

public class DeleteListDuplicationNode {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
     * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode node = new ListNode(-1);
        node.next = pHead;
        ListNode current = node.next;
        ListNode pre = node;
        while (current != null && current.next != null) {
            if (current.val != current.next.val) {
                pre = current;
                current = current.next;
            } else {
                ListNode t = current;
                do {
                    current = current.next;
                } while (current != null && current.val == t.val);
                pre.next = current;
            }
        }
        return node.next;
    }
}
