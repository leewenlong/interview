package algorithm.leetcode;

public class A10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (null == s || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');//第一个字符
        if (p.length() > 1 && p.charAt(1) == '*') {
            return (first && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            return first && isMatch(s.substring(1), p.substring(1));
        }
    }
}
