package interview.offer;

public class ConvertBinTree2List {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left==null&&pRootOfTree.right == null){
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left);
        TreeNode currentRight = left;
        while (currentRight!=null && currentRight.right!=null){
            currentRight = currentRight.right;
        }

        if (left != null) {
            currentRight.right = pRootOfTree;
            pRootOfTree.left = currentRight;
        }

        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left==null?pRootOfTree:left;
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
