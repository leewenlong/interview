package algorithm.leetcode;

import java.util.Arrays;
import java.util.Random;

public class A384_ShuffleAnArray {
    class Solution {

        private int[] origin;
        public Solution(int[] nums) {
            origin = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] res = Arrays.copyOf(origin,origin.length);
            Random random = new Random();
            for (int i = origin.length; i >1; i--) {
                int j = random.nextInt(i);
                int t = res[i-1];
                res[i-1] = res[j];
                res[j] = t;
            }
            return res;
        }
    }
}
