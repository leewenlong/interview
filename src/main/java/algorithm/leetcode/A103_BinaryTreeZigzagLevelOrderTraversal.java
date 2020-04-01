package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        List<Integer> temp = new ArrayList<>();
        while (!stack2.isEmpty() || !stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                temp.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }

            }
            if (!temp.isEmpty()) {
                res.add(temp);
                temp = new ArrayList<>();
            }

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                temp.add(node.val);
                if (node.right != null) {
                    stack2.add(node.right);
                }
                if (node.left != null) {
                    stack2.add(node.left);
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);
                temp = new ArrayList<>();
            }
        }
        return res;
    }
}
