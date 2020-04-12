package algorithm.leetcode;

public class A96_UniqueBinarySearchTrees {
    /**
     * catalan数的一个应用
     * f(n) = f(0)*f(n-1) + f(1)*f(n-2) + f(2)*f(n-3) + ... + f(n-1)*f(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
