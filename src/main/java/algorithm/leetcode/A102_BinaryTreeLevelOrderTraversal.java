package algorithm.leetcode;

import java.util.*;

public class A102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root){
            return null;
        }
        TreeNode dummy = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(dummy);
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode pop = queue.poll();
            if (pop == dummy){
                queue.add(dummy);
                result.add(temp);
                temp = new ArrayList<>();
                if (queue.isEmpty()){
                    break;
                }
                pop = queue.poll();
            }
            temp.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right!=null){
                queue.add(pop.right);
            }
        }
        return result;
    }
}
