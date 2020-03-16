package interview.offer;

public class NumberOf1InBinaryNum {
    /**
     *
     输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0){
            if ((n&1)==1){
                count ++;
            }
            n >>>=1;
        }
        return count;
    }
}
