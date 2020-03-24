package algorithm.leetcode;

public class A268_MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor^i^nums[i];
        }
        return xor == 0?nums.length:xor;
    }

    public int missingNumberII(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + i - nums[i];
        }
        return nums.length+sum;
    }
}
