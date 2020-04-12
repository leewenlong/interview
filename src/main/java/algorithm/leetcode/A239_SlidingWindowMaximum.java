package algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class A239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(k, (Integer a, Integer b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int left = 0;
        int right = k;
        while (right < nums.length) {
            res[left] = queue.peek();
            queue.remove(nums[left++]);
            queue.add(nums[right++]);
        }
        res[left] = queue.peek();//add the last one
        return res;
    }
}
