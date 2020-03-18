package algorithm.testcase;

import algorithm.primary.sort.InsertSort;
import algorithm.primary.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class TestSort {


    @Test
    public void testMerge() {
        int[] testArrays = {1, 3, 40, -2, 4, 7, 0};
        int[] reslut = {-2, 0, 1, 3, 4, 7, 40};
        MergeSort.mergeSort(testArrays);
        Assert.assertArrayEquals(reslut, testArrays);
    }

    @Test
    public void testInsert() {
        int[] testArrays = {1, 3, 40, -2, 4, 7, 0};
        int[] reslut = {-2, 0, 1, 3, 4, 7, 40};
        InsertSort.insertSort(testArrays);
        Assert.assertArrayEquals(reslut, testArrays);
    }

    @Test
    public void testBinaryInsert() {
        int[] testArrays = {1, 3, 40, -2, 4, 7, 0};
        int[] reslut = {-2, 0, 1, 3, 4, 7, 40};
        InsertSort.binaryInsertSort(testArrays);
        Assert.assertArrayEquals(reslut, testArrays);
    }


}
