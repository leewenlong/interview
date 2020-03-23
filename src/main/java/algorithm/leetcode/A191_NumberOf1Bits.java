package algorithm.leetcode;

public class A191_NumberOf1Bits {
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int num = 0;
        while (n!=0){
            num += n & 1;
            n >>>= 1;
        }
        return num;
    }
}
