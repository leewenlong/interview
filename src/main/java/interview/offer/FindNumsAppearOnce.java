package interview.offer;

public class FindNumsAppearOnce {
    /**
     *一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null||array.length==0) {
            return;
        }

        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            res ^= array[i];
        }
        int i = 0;
        for (; i < 32; i++) {
            if (((res>>i)&1)==1){
                break;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (((array[j]>>i)&1)==1){
                num1[0] ^= array[j];
            }else {
                num2[0] ^= array[j];
            }
        }
    }
}
