package algorithm.leetcode;

import java.util.Stack;

public class A98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, null, null);
    }

    public boolean isValidBSTII_UseStack(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> node = new Stack<>();
        TreeNode pre = null;
        while (root!=null || !node.isEmpty()){
            while (root!=null){
                node.push(root);
                root = root.left;
            }
            root = node.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (null != max && root.val >= max) {
            return false;
        }
        if (null != min && root.val <= min) {
            return false;
        }
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);

    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(Integer.MAX_VALUE);
//        n.left = new TreeNode(Integer.MAX_VALUE);
        System.out.println(new A98_ValidateBinarySearchTree().isValidBSTII_UseStack(n));
    }
}
