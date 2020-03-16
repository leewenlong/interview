package interview.offer;

public class HasSubtree {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。
     * （ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = HasSubtree0(root1.left, root2.left)
                        && HasSubtree0(root1.right, root2.right);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2)
                        || HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private boolean HasSubtree0(TreeNode root1,TreeNode root2){
        if (root2 == null) {
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return HasSubtree0(root1.left,root2.left)
                    && HasSubtree0(root1.right,root2.right);
        }else {
            return false;
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
