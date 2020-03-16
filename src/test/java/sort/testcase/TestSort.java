package sort.testcase;

import algorithm.common.sort.QuickSort;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] testArrays = {1,3,40,-2,4,7,0};
        QuickSort.quickSort(testArrays);
        System.out.println(Arrays.toString(testArrays));
    }
}
