package algorithm.leetcode;

public class A42_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int lMax = height[left];
        int rMax = height[right];
        int res = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                lMax = Math.max(lMax, height[left]);
                res += lMax - height[left];
                left++;
            } else {
                rMax = Math.max(rMax, height[right]);
                res += rMax - height[right];
                right--;
            }
        }

        return res;
    }
}
