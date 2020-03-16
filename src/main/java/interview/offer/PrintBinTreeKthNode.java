package interview.offer;

public class PrintBinTreeKthNode {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4
     */
    int count;
    TreeNode node;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) {
            return pRoot;
        }
        count = k;
        inOrder(pRoot);
        return node;
    }

    void inOrder(TreeNode root) {
        if (root == null || count <0) {
            return;
        }
        inOrder(root.left);
        count--;
        if (count == 0) {
            node = root;
            return;
        }
        inOrder(root.right);
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
