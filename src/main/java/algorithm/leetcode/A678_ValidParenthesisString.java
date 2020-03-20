package algorithm.leetcode;

import java.util.LinkedList;

public class A678_ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        LinkedList<Integer> stars = new LinkedList<>();
        LinkedList<Integer> left = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stars.push(i);
            } else if (c == '(') {
                left.push(i);
            } else {
                if (left.isEmpty() && stars.isEmpty()) {
                    return false;
                }
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    stars.pop();
                }
            }
        }

        while (!stars.isEmpty() && !left.isEmpty()) {
            if (left.peek() > stars.peek()) {
                return false;
            } else {
                stars.pop();
                left.pop();
            }
        }

        return left.isEmpty();
    }

    /**
     * 第二种代码简单易懂的方法
     *
     * @param s
     * @return
     */
    public boolean checkValidString1(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int count = 0;//左括号或右括号的数量

        //第一次把*全部当作(
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                count++;
            } else {
                count--;//遇到可以配对右括号的消除一个
            }
            if (count < 0) {
                return false;
            }
        }
        if (count == 0) {
            return true;
        }
        count = 0;
        //第二次把*全部当作)
        for (int i = s.length() - 1; i > 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                count++;
            } else {
                count--;//遇到可以配对右括号的消除一个
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A678_ValidParenthesisString().checkValidString2(")("));
    }

    /**
     * 主要想法是在匹配完左括号数量不为0时，把*当作右括号
     * 如果最后）数量小于0，则证明把*全部当作(都不够用，匹配失败
     *
     * @param s
     * @return
     */
    private boolean checkValidString2(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0;//当前匹配完后剩余左括号个数
        int right = 0;//需要的（右括号的个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
                right++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                }
                right--;
            } else {
                if (left > 0) {
                    left--;
                }
                right++;
            }
            if (right < 0) {
                return false;
            }
        }
        return left == 0;
    }

}
