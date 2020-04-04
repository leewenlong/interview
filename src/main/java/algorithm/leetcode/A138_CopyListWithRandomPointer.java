package algorithm.leetcode;

public class A138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node a = head;
        while (a !=null){
            Node node = new Node(a.val);
            node.next = a.next;
            a.next = node;
            a = node.next;
        }
        a = head;
        while (a!=null){
            if (a.random!=null){
                a.next.random = a.random.next;
            }
            a = a.next.next;
        }
        Node res = head.next;
        Node b = res;
        while (b.next!=null){
            head.next = b.next;
            b.next = b.next.next;
            b = b.next;
            head = head.next;
        }
        head.next =null;
        return res;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}