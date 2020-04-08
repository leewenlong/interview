package algorithm.leetcode;

import java.util.Arrays;

public class A106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null
                || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
        return root;
    }

    public TreeNode buildTreeII(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null
                || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int i, int x, int[] postorder, int j, int y) {
        if (i > x || j > y) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[y]);
        int k = i;
        for (; k <= x; k++) {
            if (inorder[k] == root.val) {
                break;
            }
        }
        root.left = buildTree(inorder, i, k - 1, postorder, j, j + (k - i - 1));
        root.right = buildTree(inorder, k + 1, x, postorder, j + (k - i), y - 1);
        return root;
    }

}
