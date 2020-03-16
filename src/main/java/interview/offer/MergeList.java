package interview.offer;

public class MergeList {

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null ) {
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode root = new ListNode(-1);
        ListNode merged = root;
        while (list1!=null && list2!=null){
            if (list1.val<=list2.val){
                merged.next = list1;
                list1 = list1.next;
            }else {
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }
        if(null!=list1){
            merged.next = list1;
        }
        if (list2 != null) {
            merged.next = list2;
        }

        return root.next;

    }
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
