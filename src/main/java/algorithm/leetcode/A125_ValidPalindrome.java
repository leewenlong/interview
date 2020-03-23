package algorithm.leetcode;

public class A125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !isAlph(s.charAt(l))) {
                l++;
            }
            while (l < r && !isAlph(s.charAt(r))) {
                r--;
            }
            if (l < r && s.charAt(l) != s.charAt(r)) {
                return false;
            }
            while (l < r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isAlph(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}
