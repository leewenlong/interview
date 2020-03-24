package algorithm.leetcode;

public class A258_AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int res;
        do {
            res = 0;
            while (num != 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
        } while (res >= 10);
        return res;
    }

    public int addDigitsII(int num) {
        if (num < 10) {
            return num;
        }
        return 1 + (num - 1) % 9;
    }
}
