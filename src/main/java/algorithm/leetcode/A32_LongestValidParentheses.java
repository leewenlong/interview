package algorithm.leetcode;

public class A32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int num = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                num++;
            } else if (c == ')') {
                if (num > 0) {
                    dp[i] = dp[i - 1] + 2;//本次匹配数量
                    int last = i - dp[i] > 0 ? i - dp[i] : 0;//无缝连接上次匹配数量，有缝的话上次就是0
                    dp[i] = dp[last] + dp[i];
                    max = Math.max(dp[i], max);
                    num--;
                }
            }
        }
        return max;
    }
}
