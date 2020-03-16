package interview.offer;

public class FindGreatestSumOfSubArray {
    /**
     * 给一个数组，返回它的最大连续子序列的和,例如:{6,-3,-2,7,-15,1,2,2},
     * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * (子向量的长度至少是1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
