package algorithm.leetcode;

import java.util.Arrays;

public class A179_LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] s = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = nums[i];
        }
        Arrays.sort(s,(Integer o1,Integer o2)->(o1+""+o2).compareTo(o2+""+o1));
        if (s[s.length-1] ==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length-1; i >=0; i--) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
}
