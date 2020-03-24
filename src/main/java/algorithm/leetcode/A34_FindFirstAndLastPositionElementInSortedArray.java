package algorithm.leetcode;

public class A34_FindFirstAndLastPositionElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }

        int l = 0;
        int r = nums.length - 1;
        if (r == 1 && nums[0] == target) {
            res[0] = res[1] = 0;
            return res;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                int i = m - 1;
                for (; i >= 0; i--) {
                    if (nums[i] != target) {
                        break;
                    }
                }
                res[0] = i + 1;
                i = m + 1;
                for (; i < nums.length; i++) {
                    if (nums[i] != target) {
                        break;
                    }
                }
                res[1] = i - 1;
                return res;
            }
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}
