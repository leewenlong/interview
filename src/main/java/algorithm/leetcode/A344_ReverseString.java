package algorithm.leetcode;

public class A344_ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <1) {
            return;
        }
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char t = s[left];
            s[left++] = s[right];
            s[right--] = t;
        }
    }
}
