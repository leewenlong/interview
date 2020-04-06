package algorithm.leetcode;

import java.util.Stack;

public class A230_KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
