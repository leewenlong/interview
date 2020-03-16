package interview.offer;

import java.util.ArrayList;

public class FindContinuousSequence {
    /**
     *
     * @param sum
     * @return 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，
     * 序列间按照开始数字从小到大的顺序
     *
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        /**
         * 等差数列算法, i = end - start +1, j = start + end
         * i*j = 2*sum，且 j>i, i^2<2*sum,
         */
        int doubleSum = 2*sum;
        int i = (int)Math.sqrt(doubleSum);
        int j,start,end;
        for (; i >=2 ; i--) {
            if ((doubleSum%i)==0){
                j = doubleSum/i;
                start = j-i+1;//j-i+1=2*start
                if ((start&1)==0){
                    start = start>>1;
                    ArrayList<Integer> list = new ArrayList<>();
                    end = j-start;
                    while (start<=end){
                        list.add(start++);
                    }
                    result.add(list);
                }
            }
        }


        return result;
    }

    /**
     * tcp窗口算法
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        int mid = (sum+1)>>1;
        int currentSum = 3;
        while (left<mid){
            if (currentSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                result.add(list);
                right++;
                currentSum+=right;
                currentSum-=left;
                left++;

            }
            if (currentSum>sum){
                currentSum-=left;
                left++;
            }
            if (currentSum<sum){
                right++;
                currentSum+=right;
            }
        }


        return result;
    }
}
