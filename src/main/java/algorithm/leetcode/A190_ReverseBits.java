package algorithm.leetcode;

public class A190_ReverseBits {
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1 | (1 & n);
            n >>= 1;
        }
        return res;
    }
}
