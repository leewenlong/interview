package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        inorder(root,list);
        root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            root.left = null;
            root.right = list.get(i);
            root = root.right;
        }
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        inorder(root.left,list);
        inorder(root.right,list);
    }

    public void flattenII(TreeNode root) {
        while (root!=null){
            if (root.left !=null){
                TreeNode pre = root.left;
                while (pre.right!=null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
