package algorithm.leetcode;

public class A198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        for (int num : nums) {
            int t = p1;
            p1 = Math.max(p1, p2 + num);
            p2 = t;
        }
        return p1;
    }


    public int robII(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1], nums[i] + result[i - 2]);
        }
        return result[nums.length - 1];
    }
}
