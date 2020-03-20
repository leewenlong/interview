package algorithm.leetcode;

public class A88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c = n + m - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[c--] = nums2[n - 1];
                n--;
            } else {
                nums1[c--] = nums1[m - 1];
                m--;
            }
        }
        while (n > 0) {
            nums1[c--] = nums2[n - 1];
            n--;
        }
    }
}
