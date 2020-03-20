package algorithm.leetcode;

public class A53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            result = result > nums[i] ? result : nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new A53_MaximumSubarray().maxSubArray(a));
    }
}
