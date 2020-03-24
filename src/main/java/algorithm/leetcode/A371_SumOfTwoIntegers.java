package algorithm.leetcode;

public class A371_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int xor = 0;
        do {
            xor = a ^ b;//累加
            a = (a & b) << 1;//进位
            b = xor;
        } while (a != 0);
        return xor;
    }
}
