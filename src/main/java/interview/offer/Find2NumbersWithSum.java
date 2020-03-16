package interview.offer;

import java.util.ArrayList;

public class Find2NumbersWithSum {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * @param array
     * @param sum
     * @return 对应每个测试案例，输出两个数，小的先输出。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null||array.length<2) {
            return list;
        }
        int left = 0;
        int right = array.length-1;
        int temp;
        while (left<right){
            temp = array[left]+array[right];
            if (temp == sum){
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
            if (temp > sum){
                right--;
            }
            if (temp < sum){
                left++;
            }
        }
        return list;
    }
}
