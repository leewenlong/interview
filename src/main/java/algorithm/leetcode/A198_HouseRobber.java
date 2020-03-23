package algorithm.leetcode;

public class A198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        for (int num : nums) {
            int t = p1;
            p1 = Math.max(p1, p2 + num);
            p2 = t;
        }
        return p1;
    }
}
