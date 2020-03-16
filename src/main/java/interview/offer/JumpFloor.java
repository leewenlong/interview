package interview.offer;

public class JumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法
     * （先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        //same as Fibonacci
        if(target<=1){
            return target;
        }
        int result = 0;
        int pre = 1;
        int prePre=0;
        for (int i = 2; i <=target; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
