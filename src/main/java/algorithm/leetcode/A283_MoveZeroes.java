package algorithm.leetcode;

public class A283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0 ){
                int t = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex++] = t;
            }
        }
    }

    public void moveZeroesII(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zero++] = nums[i];
            }
        }

        while (zero < nums.length) {
            nums[zero++] = 0;
        }
    }
}
