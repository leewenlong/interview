package algorithm.leetcode;

import java.util.Arrays;

public class A41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int res = 1;
        if (nums==null||nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if (num>=res){
                if (num!=res){
                    return res;
                }
                res++;
            }
        }
        return res;
    }
}
