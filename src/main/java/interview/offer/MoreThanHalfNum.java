package interview.offer;

public class MoreThanHalfNum {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     * 如果不存在则输出0。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int halfNum = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            int j = array[i];
            if (halfNum == j){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                halfNum = j;
                count++;
            }
        }
        count = 0;
        for (int i : array) {
            if (i == halfNum){
                count++;
            }
        }
        return count>array.length/2?halfNum:0;
    }
}
