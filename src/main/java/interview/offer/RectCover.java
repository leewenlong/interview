package interview.offer;

public class RectCover {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target<=2){
            return target;
        }
        int result = 0;
        int pre = 2;
        int prePre=1;
        for (int i = 3; i <=target; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

}
