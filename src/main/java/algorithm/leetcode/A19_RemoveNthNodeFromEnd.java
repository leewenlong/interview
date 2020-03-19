package algorithm.leetcode;

public class A19_RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n<1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second=second.next;
        }
//        while (first != null){
//            first = first.next;
//            n--;
//            if (n < -1) {
//                second=second.next;
//            }
//        }
        second.next = second.next.next;

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}