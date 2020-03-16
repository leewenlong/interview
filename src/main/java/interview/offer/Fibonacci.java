package interview.offer;

public class Fibonacci {
    /**
     * 斐波那契数列,1:保存已经计算过的值，2:转换为矩阵，用快速乘法幂
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n<=1){
            return n;
        }
        int result = 0;
        int pre = 1;
        int prePre=0;
        for (int i = 2; i <=n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
