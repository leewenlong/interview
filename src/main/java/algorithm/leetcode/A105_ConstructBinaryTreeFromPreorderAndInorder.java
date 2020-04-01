package algorithm.leetcode;

import java.util.Arrays;

public class A105_ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                if (i < len - 1) {
                    root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, len), Arrays.copyOfRange(inorder, i + 1, len));
                }
                break;
            }
        }
        return root;
    }

    public TreeNode buildTreeII(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int start, int end) {
        if (start > end || preStart > preorder.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(preorder, preStart + 1, inorder, start, i - 1);
                root.right = buildTree(preorder, preStart + (i - start) + 1, inorder, i + 1, end);
            }
        }
        return root;
    }



}
