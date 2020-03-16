package interview.offer;

import java.util.Stack;

public class FindKthToTail {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     * 1.借用栈
     * 2.倒数第k个，即正数len-k+1个
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        int i = 0;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            i++;
            if (k == i){
                return pop;
            }
        }
        return null;
    }
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
