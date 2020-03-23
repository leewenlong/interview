package algorithm.leetcode;

public class A231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        return (n&(n-1)) == 0;
    }
}
