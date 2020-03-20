package algorithm.leetcode;

import java.util.HashMap;

public class A1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();//value,index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
