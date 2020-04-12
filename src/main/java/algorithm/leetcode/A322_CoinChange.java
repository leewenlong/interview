package algorithm.leetcode;

import java.util.Arrays;

public class A322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] == j) {
                    dp[j] = 1;
                    continue;
                }
                int t = j - coins[i];
                if (t > 0 && dp[t] != 0) {
                    dp[j] = Math.min(dp[t] + 1, dp[j] > 0 ? dp[j] : Integer.MAX_VALUE);
                }
            }
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }

    public int coinChangeII(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }

}
