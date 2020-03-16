package interview.offer;

public class ReverseList {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (null != head){
            next = head.next;
            head.next=pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
