package algorithm.leetcode;

public class A122_BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]){
                buy = prices[i];
            }else if (prices[i] -buy >0){
                max += prices[i] -buy;
                buy = prices[i];
            }
        }
        return max;
    }
}
