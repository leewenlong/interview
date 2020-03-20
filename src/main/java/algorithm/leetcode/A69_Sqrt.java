package algorithm.leetcode;

public class A69_Sqrt {
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        int left = 2;
        int right = x / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x / mid >= mid) {
                left = mid + 1;
                if (x / left < left) {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
