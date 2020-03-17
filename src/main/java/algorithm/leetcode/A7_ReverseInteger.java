package algorithm.leetcode;

public class A7_ReverseInteger {

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {//注意负数与溢出
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && x % 10 >= Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (Integer.MIN_VALUE / 10 > res || (Integer.MIN_VALUE / 10 == res && x % 10 <= Integer.MIN_VALUE)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res;
    }
}
