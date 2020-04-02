package algorithm.leetcode;

public class A116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = root;
        Node curr;
        while (pre.left != null){
            curr = pre;
            while (curr!=null){
                curr.left.next = curr.right;
                if (curr.next !=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            pre = pre.left;
        }
        return root;
    }


}
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
