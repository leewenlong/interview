package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (null!=root || !stack.isEmpty()){
            while (root!=null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop().right;
            }
        }
        return list;
    }
}
