package algorithm.leetcode;

public class A237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode t = node;
        while (node.next!=null){
            t = node;
            node.val = node.next.val;
            node = node.next;

        }
        t.next = null;
    }
}
