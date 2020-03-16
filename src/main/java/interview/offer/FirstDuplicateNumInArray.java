package interview.offer;

import java.util.BitSet;

public class FirstDuplicateNumInArray {
    public static void main(String[] args) {
        int[] ar = {4,2,3,1,4};
        int[] ans = new int[1];
         new FirstDuplicateNumInArray().duplicate(ar,ar.length,ans);
        System.out.println(ans[0]);
    }
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
     * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate_1(int numbers[],int length,int [] duplication) {
        if (numbers == null||numbers.length!=length||numbers.length==0) {
            return false;
        }
        BitSet set = new BitSet();
        for (int i = 0; i < length; i++) {
            if (set.get(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            set.set(numbers[i]);
        }
        return false;
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null||numbers.length!=length||numbers.length==0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int current = numbers[i];
            if(current<0||current>=length){
                return false;
            }
            if (current!=i){
                int t = numbers[current];
                if (t == current){
                    duplication[0] = current;
                    return true;
                }
                numbers[current] = current;
                numbers[i]=t;

            }
        }
        return false;
    }
}
