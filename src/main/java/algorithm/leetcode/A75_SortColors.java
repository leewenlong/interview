package algorithm.leetcode;

public class A75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int one = 0;
        int two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            if (nums[i] == 0) {
                swap(nums, one++, i);
            } else if (nums[i] == 2) {
                swap(nums, two--, i--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
