package algorithm.testcase;

import algorithm.leetcode.A56_MergeIntervals;
import org.junit.Assert;
import org.junit.Test;

public class A56 {
    @Test
    public void testMergeInterval() {

        A56_MergeIntervals mergeIntervals = new A56_MergeIntervals();

        int[][] a = {
                {1, 4}
        };

        int[][] merge = mergeIntervals.merge(a);
        Assert.assertArrayEquals(new int[]{1, 4}, merge[0]);

        int[][] b = {
                {1, 4},
                {0, 2},
                {3, 5}};
        merge = mergeIntervals.merge(b);
        Assert.assertEquals(1,merge.length);
        Assert.assertArrayEquals(new int[]{0, 5}, merge[0]);

        int[][] c = {
                {1, 3},
                {2, 6},
                {0, 10},
                {15, 18}};
        merge = mergeIntervals.merge(c);

        Assert.assertEquals(2,merge.length);
        Assert.assertArrayEquals(new int[]{0, 10}, merge[0]);
        Assert.assertArrayEquals(new int[]{15, 18}, merge[1]);

        int[][] d = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};
        merge = mergeIntervals.merge(d);
        Assert.assertEquals(3,merge.length);
        Assert.assertArrayEquals(new int[]{1, 6}, merge[0]);
        Assert.assertArrayEquals(new int[]{8, 10}, merge[1]);
        Assert.assertArrayEquals(new int[]{15, 18}, merge[2]);

        int[][] e = {
                {1, 4},
                {0, 1}
        };
        merge = mergeIntervals.merge(e);
        Assert.assertEquals(1,merge.length);
        Assert.assertArrayEquals(new int[]{0, 4}, merge[0]);
    }
}
