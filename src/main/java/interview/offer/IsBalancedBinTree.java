package interview.offer;

public class IsBalancedBinTree {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return -1 != IsBalanced_Solution0(root);
    }
    public int IsBalanced_Solution0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = IsBalanced_Solution0(root.left);
        if(left == -1){
            return -1;
        }
        int right = IsBalanced_Solution0(root.right);
        if (right == -1){
            return -1;
        }
        return Math.abs(left-right)>1?-1:Math.max(left,right)+1;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
