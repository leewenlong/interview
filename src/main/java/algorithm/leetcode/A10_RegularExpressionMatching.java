package algorithm.leetcode;

public class A10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (null == s || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first = !s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');//第一个字符
        if (p.length()>1 && p.charAt(1)=='*'){
            return (first&&isMatch(s.substring(1),p))||isMatch(s,p.substring(2));
        }else {
            return first&& isMatch(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args) {
        A10_RegularExpressionMatching m = new A10_RegularExpressionMatching();
        System.out.println(m.isMatch("aa","a"));
        System.out.println(m.isMatch("aa","a*"));
        System.out.println(m.isMatch("ab",".*"));
        System.out.println(m.isMatch("aab","c*a*b"));
        System.out.println(m.isMatch("mississippi","mis*is*p*."));
        System.out.println(m.isMatch("ab",".*c"));
//        System.out.println(m.isMatch("pi","p*."));
//        System.out.println("".matches("m*p*"));
//        System.out.println("aa".matches("a*d"));
    }
}
