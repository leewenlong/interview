package algorithm.leetcode;

public class A72_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * pre       |  curr[i]
     * ------------
     * curr[i-1] |  curr[i] (need update)
     *
     * @param word1
     * @param word2
     * @return
     */

    public int minDistanceII(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        int dp[] = new int[n];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];//左上角
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(temp,
                            Math.min(dp[j - 1], pre)) + 1;
                }
                pre = temp;
            }
        }
        return dp[n];
    }
}
