package interview.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class PrintBinTreeZigzag {
    /**
     * 按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
     * 其他行以此类推。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(pRoot);
        int level = 0;
        while (!nodes.isEmpty()) {
            LinkedList<TreeNode> temp = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>(nodes.size());
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            if ((level & 1) != 0){//奇数层从右向左
                Collections.reverse(list);
            }
            result.add(list);
            level++;
            nodes.addAll(temp);
        }
        return result;
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
