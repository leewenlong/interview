package algorithm.leetcode;

import java.util.Arrays;

public class A26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int pre = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new A26_RemoveDuplicatesFromSortedArray().removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }
}
