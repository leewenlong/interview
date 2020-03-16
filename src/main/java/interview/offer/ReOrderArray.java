package interview.offer;

public class ReOrderArray {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array == null) {
            return;
        }
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&1)==1) {
                if(i==start){
                    start++;
                }else {
                    int t = array[i];
                    for (int j = i; j > start; j--) {
                        array[j] = array[j-1];
                    }
                    array[start++] = t;
                }
            }
        }
    }
}
