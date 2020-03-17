package algorithm.leetcode;

public class A4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }

        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        int len = len1 + len2;
        int mid = len >> 1;
        boolean even = (len & 1) == 0;
        //以下为归并排序
        int left = 0;
        int right = 0;
        int[] temp = new int[len];
        int index = 0;
        while (left < len1 && right < len2) {
            temp[index++] = nums1[left] < nums2[right] ? nums1[left++] : nums2[right++];
        }
        while (left < len1) {
            temp[index++] = nums1[left++];
        }
        while (right < len2) {
            temp[index++] = nums2[right++];
        }

        return even ? (temp[mid - 1] + temp[mid]) / 2.0 : temp[mid];
    }
}
