package interview.offer;

import java.util.ArrayList;

public class PrintListFromTail2Head {

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
