package algorithm.testcase;

import algorithm.leetcode.A48_RotateImage;
import org.junit.Assert;
import org.junit.Test;

public class A48 {

    @Test
    public void testRotote(){
         int[][] originA = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

         int[][] rotateA = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };

         int[][] originB = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
         int[][] rotateB = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };

        A48_RotateImage rotateImage = new A48_RotateImage();
        rotateImage.rotate(originA);
        for (int i = 0; i < originA.length; i++) {
            Assert.assertArrayEquals(rotateA[i],originA[i]);
        }

        rotateImage.rotate(originB);
        for (int i = 0; i < originB.length; i++) {
            Assert.assertArrayEquals(rotateB[i],originB[i]);
        }
    }

    @Test
    public void testRototeII(){
        int[][] originA = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        int[][] rotateA = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };

        int[][] originB = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] rotateB = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };

        A48_RotateImage rotateImage = new A48_RotateImage();
        rotateImage.rotateII(originA);
        for (int i = 0; i < originA.length; i++) {
            Assert.assertArrayEquals(rotateA[i],originA[i]);
        }

        rotateImage.rotateII(originB);
        for (int i = 0; i < originB.length; i++) {
            Assert.assertArrayEquals(rotateB[i],originB[i]);
        }
    }

}
