package algorithm.leetcode;

public class A29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        int res = 0;
        while (m >= n) {
            int i = 1;//成倍扩大的除数的个数
            long t = n;
            while (m > (t << 1)) {//成倍的扩大除数，跟被除数比较
                t <<= 1;
                i <<= 1;
            }
            res += i;
            m -= t;//缩小被除数，减去已经成倍扩大的除数
        }
        return sign == 1 ? res : -res;
    }
}
