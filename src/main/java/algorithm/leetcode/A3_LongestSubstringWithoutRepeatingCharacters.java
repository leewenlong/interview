package algorithm.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new A3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcddae"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()<1) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int max = 1;
        int left= 0;
        int right = 0;
        while (left < s.length() && right<s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                max = Math.max(max,right-left);
            }else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }
}
