package algorithm.leetcode;

public class A137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum+=(nums[j]>>i)&1;
            }
            sum = sum%3;
            ans |= sum<<i;
        }
        return ans;
    }


    //genius
    public int singleNumber_Another(int[] nums) {
        int first = 0;
        int second = 0;
        for (int num : nums) {
            first = (first ^ num) & ~second;
            second = (second ^ num) & ~first;
        }

        return first;
    }
}
