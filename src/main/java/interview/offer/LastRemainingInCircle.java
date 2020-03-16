package interview.offer;

public class LastRemainingInCircle {
    /**
     * 小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m-1的那个小朋友要出列,并且不再回到圈中,从他的下一个小朋友开始,
     * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友。请你试着想下,
     * 这个小朋友的编号是多少呢？(注：小朋友的编号是从0到n-1)
     * 如果没有小朋友，请返回-1
     * @param n
     * @param m
     * @return
     * 原理：约瑟夫环问题
     * 详见：https://blog.csdn.net/liujian20150808/article/details/50926614
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n<=0||m<=0){
            return -1;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result+m)%i;
        }
        return result;
    }
}
