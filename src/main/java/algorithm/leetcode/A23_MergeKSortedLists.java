package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode a,b;
        List<ListNode> c = new ArrayList<>();
        int l = 0;
        int r = lists.length-1;
        while (l<=r){
            b = null;
            a = mergeKLists(lists[l++], lists[r--]);
            if (l<=r){
                b = mergeKLists(lists[l++], lists[r--]);
            }
            c.add(mergeKLists(a,b));
        }
        if (c.size() == 1){
            return c.get(0);
        }
        return mergeKLists(c.toArray(new ListNode[0]));
    }
    public ListNode mergeKLists(ListNode a,ListNode b) {
        if (a == null ||a ==b) {
            return b;
        }
        if (b == null){
            return a;
        }
        ListNode t = new ListNode(-1);
        ListNode next = new ListNode(-1);
        t.next = next;
        while (a!=null&&b!=null){
            if (a.val<=b.val){
                next.next = a;
                a = a.next;
            }else {
                next.next = b;
                b = b.next;
            }
            next = next.next;
        }
        if (a!=null){
            next.next = a;
        }
        if (b!=null){
            next.next = b;
        }
        return t.next.next;
    }

}
