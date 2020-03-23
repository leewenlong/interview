package algorithm.leetcode;

public class A172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n>4){
            res +=res/5;
            n = n/5;
        }
        return res;
    }
}
