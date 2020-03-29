package algorithm.testcase;

import algorithm.leetcode.A54_SpiralMatrix;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A54 {
    @Test
    public void testSpiralMatrix() {
        A54_SpiralMatrix s = new A54_SpiralMatrix();

        int[][] a = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        List<Integer> expected = Arrays.asList(5, 1, 9, 11, 10, 7, 16, 12, 14, 15, 13, 2, 4, 8, 6, 3);
        List<Integer> list = s.spiralOrder(a);
        Assert.assertEquals(expected, list);
    }
}
