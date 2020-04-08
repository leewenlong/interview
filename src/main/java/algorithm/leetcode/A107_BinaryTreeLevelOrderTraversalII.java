package algorithm.leetcode;

import java.util.*;

/**
 * @see A102_BinaryTreeLevelOrderTraversal
 */
public class A107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root){
            return new ArrayList<>();
        }
        Queue<TreeNode> odd = new LinkedList<>();
        odd.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> even = new LinkedList<>();
        while (!odd.isEmpty()||!even.isEmpty()) {
            while (!odd.isEmpty()) {
                TreeNode remove = odd.remove();
                temp.add(remove.val);
                if (remove.left != null) {
                    even.add(remove.left);
                }
                if (remove.right != null) {
                    even.add(remove.right);
                }
            }
            if (!temp.isEmpty()){
                stack.add(temp);
                temp = new ArrayList<>();
            }
            while (!even.isEmpty()) {
                TreeNode remove = even.remove();
                temp.add(remove.val);

                if (remove.left != null) {
                    odd.add(remove.left);
                }
                if (remove.right != null) {
                    odd.add(remove.right);
                }
            }
            if (!temp.isEmpty()){
                stack.add(temp);
                temp = new ArrayList<>();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return stack;
    }
}
