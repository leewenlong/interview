package algorithm.other;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {
    /**
     * 0/1背包问题朴素解法
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
                    int add = val[i - 1] + dp[i - 1][remainW];
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

        System.out.println(new KnapsackProblem().maxValueII(N, W, wt, val));

        int s=16,t=1;
        while (s>=t) {
            System.out.println(t+","+s);
            s-=t;
            t*=2;
        }
        System.out.println(s);
    }

    /**
     * 0/1背包问题状态压缩
     * @param n
     * @param w
     * @param wt
     * @param val
     * @return
     */
    public int maxValueII(int n, int w, int[] wt, int[] val) {
        int[] dp = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w; j > 0; j--) {
                if (j >= wt[i]) {
                    dp[j] = Math.max(dp[j - 1], val[i] + dp[j - wt[i]]);
                }
            }
        }
        return dp[w];
    }

    /**
     * 完全背包问题朴素解法
     * @param n
     * @param w
     * @param wt
     * @param val
     * @return
     */
    public int maxValueIII(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n+1][w+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                for (int k = 0; k <= j / wt[i-1]; k++) {
                    dp[i][j] = Math.max(dp[i][j],k*val[i-1]+dp[i-1][j-k*wt[i-1]]);
                }
            }
        }
        return dp[n][w];
    }
    /**
     * 完全背包问题状态压缩
     * @param n
     * @param w
     * @param wt
     * @param val
     * @return
     */
    public int maxValueIV(int n, int w, int[] wt, int[] val) {
        int[] dp = new int[w+1];
        for (int i = 0; i < n; i++) {
            for (int j = wt[i]; j < w; j++) {
                dp[j] = Math.max(dp[j],val[i] +dp[j-wt[i]]);
            }
        }
        return dp[w];
    }

    /**
     * 多重背包问题，利用二进制思想，把多个相同的物品划分成
     * 数量（2^0,2^1,2^2....2^k）不同的几类,这样就可以把划分的这几类的看成是不同的物品
     * @param n
     * @param w
     * @param wt
     * @param val
     * @param nums 每件物品可选择的最大数量
     * @return
     */
    public int maxValueV(int n, int w, int[] wt, int[] val,int[] nums) {
        List<Integer> wList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int weight = wt[i];
            int value = val[i];
            int part = 1;
            while (num < part){
                wList.add(part*weight);
                vList.add(part*value);
                part*=2;
                num-=part;
            }
            wList.add(num*weight);
            vList.add(num*value);
        }

        int[] dp = new int[w+1];
        for (int i = 0; i < vList.size(); i++) {
            for (int j = w; j >=0 ; j--) {
                if (wList.get(i) <= w){
                    dp[j] = Math.max(dp[j-1],dp[j-wList.get(i)]+vList.get(i));
                }
            }
        }

        return dp[w];
    }
}
