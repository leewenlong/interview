package interview.offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrintFromTopToBottom {
    /**
     *从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            TreeNode left = poll.left;
            if (left != null) {
                queue.add(left);
            }
            TreeNode right = poll.right;
            if (right != null) {
                queue.add(right);
            }
        }
        return list;
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
