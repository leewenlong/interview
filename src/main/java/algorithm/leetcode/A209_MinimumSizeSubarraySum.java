package algorithm.leetcode;

public class A209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            s -= nums[right];
            if (s <= 0) {
                while (s <= 0) {
                    s += nums[left];
                    left++;
                }
                if (min > right - left + 2) {
                    min = right - left + 2;
                }
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
