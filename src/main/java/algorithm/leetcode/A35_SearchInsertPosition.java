package algorithm.leetcode;

public class A35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int i = 0;
        int j = nums.length - 1;
        int m;
        while (i <= j) {
            m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
