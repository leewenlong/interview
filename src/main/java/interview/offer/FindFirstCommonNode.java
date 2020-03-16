package interview.offer;

public class FindFirstCommonNode {
    /**
     * 输入两个链表，找出它们的第一个公共结点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //原理，两个链表分别追加对方使链表长度相等
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1!=node2){
            node1= node1==null?pHead2:node1.next;
            node2 = node2==null?pHead1:node2.next;
        }
        return node1;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
