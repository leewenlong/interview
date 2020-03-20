package algorithm.testcase;

import algorithm.leetcode.A88_MergeSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class A88 {

    @Test
    public void testMergeSortedArray(){
        int[] a ={1,2,3,0,0,0};
        int[] b ={0,3,4};
        int[] r1 ={0,1,2,3,3,4};


        int[] c = {1,2,3,0,0,0};
        int[] d={3,4,5};
        int[] r2 = {1,2,3,3,4,5};

        A88_MergeSortedArray merge = new A88_MergeSortedArray();
        merge.merge(a,3,b,3);
        Assert.assertArrayEquals(r1,a);

        merge.merge(c,3,d,3);
        Assert.assertArrayEquals(r2,c);
    }
}
