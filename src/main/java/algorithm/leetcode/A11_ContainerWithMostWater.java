package algorithm.leetcode;

public class A11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * (height[left] > height[right] ? height[right] : height[left]);
            max = max < area ? area : max;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new A11_ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
