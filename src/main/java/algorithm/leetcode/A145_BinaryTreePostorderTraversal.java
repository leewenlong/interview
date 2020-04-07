package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || last == root.right) {
                stack.pop();
                list.add(root.val);
                last = root;
                root = null;
            }else {
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
