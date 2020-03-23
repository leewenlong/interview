package algorithm.leetcode;

public class A61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null||head.next==null) {
            return head;
        }
        int len =0;
        ListNode node = head;
        while (head!=null){
            head = head.next;
            len++;
        }
        k = k%len;

        int cut = len -k-1;
        head = node;
        while (cut--!=0){
            head = head.next;
        }
        ListNode temp = head;
        while (head.next!=null){
            head = head.next;
        }
        head.next = node;
        node = temp.next;
        temp.next = null;
        return node;

    }
}
