package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSum(res, temp, root, sum);
        return res;
    }

    private void pathSum(List<List<Integer>> res, List<Integer> temp, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<>(temp));
        } else {
            pathSum(res, temp, node.left, sum - node.val);
            pathSum(res, temp, node.right, sum - node.val);
        }
        temp.remove(temp.size() - 1);
    }
}
