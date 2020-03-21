package algorithm.leetcode;

public class A700_SearchInBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
