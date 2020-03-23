package algorithm.leetcode;

public class A160_IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode first = headA;
        ListNode second = headB;
        while (first.next != null) {
            first = first.next;
        }
        while (second.next != null) {
            second = second.next;
        }
        if (first != second) {
            return null;
        }
        first = headA;
        second = headB;
        while (first != second) {
            first = first == null ? headB : first.next;
            second = second == null ? headA : second.next;
        }
        return first;
    }
}
