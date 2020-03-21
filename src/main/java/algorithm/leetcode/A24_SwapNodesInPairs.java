package algorithm.leetcode;

public class A24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        swapPairs(dummy, head);
        return dummy.next;
    }

    public void swapPairs(ListNode head, ListNode next) {
        if (next == null) {
            return;
        }
        if (next.next != null) {
            ListNode a = next;
            ListNode b = next.next;
            ListNode temp = next.next.next;

            head.next = b;
            b.next = a;
            a.next = temp;

            swapPairs(a, temp);
        }
    }

}
