package algorithm.other;

public class KnapsackProblem {
    /**
     * @param n   物品个数
     * @param w   背包容量
     * @param wt  物品重量
     * @param val 物品价值
     * @return
     */
    public int maxValue(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];//第i个物品 -- > 现在背包容量
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                int remainW = j - wt[i - 1];
                if (remainW < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int add = val[i-1]+dp[i-1][remainW];
                    dp[i][j] = Math.max(dp[i - 1][j], add);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int N = 3, W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 6};

        System.out.println(new KnapsackProblem().maxValue(N, W, wt, val));

    }
}
