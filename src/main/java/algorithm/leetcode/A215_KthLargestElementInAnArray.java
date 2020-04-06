package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>(nums.length, (Integer a, Integer b) -> (b - a));
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.remove();
        }
        return queue.peek();
    }

    public int findKthLargestII(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
