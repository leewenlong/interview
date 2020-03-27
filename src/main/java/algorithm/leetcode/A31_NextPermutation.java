package algorithm.leetcode;

import java.util.Arrays;

public class A31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int t = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = t;
                        break;
                    }
                }
                int left = i;
                int right = nums.length - 1;
                while (left < right) {
                    int t = nums[left];
                    nums[left++] = nums[right];
                    nums[right--] = t;
                }
                return;
            }
        }
        Arrays.sort(nums);
    }
}
