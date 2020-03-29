package algorithm.leetcode;

public class A55_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i > index) {
                index = i;
            }
        }
        return index == 0;
    }

    public boolean canJumpII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

}
