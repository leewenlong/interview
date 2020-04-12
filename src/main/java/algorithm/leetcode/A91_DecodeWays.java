package algorithm.leetcode;

public class A91_DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char oneChar = s.charAt(i);
            byte twoChar = Byte.parseByte(s.substring(i - 1, i + 1));
            if (oneChar > '0') {
                dp[i + 1] = dp[i];
            }
            if (twoChar <= 26 && twoChar > 0 && s.charAt(i - 1) != '0') {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
