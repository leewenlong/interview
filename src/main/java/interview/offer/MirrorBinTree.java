package interview.offer;

public class MirrorBinTree {

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            Mirror(left);
            Mirror(right);
        }
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
