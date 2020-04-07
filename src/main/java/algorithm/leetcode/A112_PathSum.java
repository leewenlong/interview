package algorithm.leetcode;

public class A112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        sum -= root.val;
        if (root.left==null && root.right == null &&  sum ==0){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum);
    }
}
