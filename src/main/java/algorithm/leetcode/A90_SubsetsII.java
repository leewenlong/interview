package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        List<Integer> temp = new ArrayList<>();
        subset(list, temp, 0, nums);
        return list;
    }

    private void subset(List<List<Integer>> list, List<Integer> temp, int i, int[] nums) {
        if (i == nums.length) {
            List<Integer> l = new ArrayList<>(temp);
            Collections.sort(l);
            if (!list.contains(l)) {
                list.add(l);
            }
            return;
        }
        subset(list, temp, i + 1, nums);
        temp.add(nums[i]);
        subset(list, temp, i + 1, nums);
        temp.remove(temp.size() - 1);
    }

}
