package algorithm.leetcode;

public class A2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        ListNode n11 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n33 = new ListNode(4);
        n1.next = n2;n2.next=n3;
        n11.next=n22;n22.next=n33;
        ListNode r = new A2_AddTwoNumbers().addTwoNumbers(n1,n11);

        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dump = new ListNode(-1);
        ListNode next = dump;
        int add = 0;
        ListNode next1 = l1;
        ListNode next2 = l2;
        while (next1 != null || next2 != null) {
            int v = add;
            if (next1 != null) {
                v += next1.val;
                next1 = next1.next;
            }
            if (next2 != null) {
                v += next2.val;
                next2 = next2.next;
            }
            add = v / 10;
            v = v % 10;
            ListNode n = new ListNode(v);
            next.next = n;
            next = n;
        }
        if (add == 1) {
            ListNode n = new ListNode(add);
            next.next = n;
        }
        return dump.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }
}

