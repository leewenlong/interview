package algorithm.leetcode;

public class A129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return backtrack(root, 0);
    }

    private int backtrack(TreeNode root, int val) {
        int sum = 0;
        int path = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += path;
        }
        if (root.left != null) {
            sum += backtrack(root.left, path);
        }
        if (root.right != null) {
            sum += backtrack(root.right, path);
        }
        return sum;
    }
}
