package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0 || intervals[0].length != 2) {
            return list.toArray(new int[0][0]);
        }

        int[][] temp = new int[intervals.length][2];
        sortStart(intervals, 0, intervals.length - 1, temp);
        int[] first = intervals[0];
        list.add(first);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= first[1]) {
                first[1] = Math.max(curr[1], first[1]);
            } else {
                first = curr;
                list.add(curr);
            }
        }
        return list.toArray(new int[0][0]);
    }

    public int[][] mergeII(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0 || intervals[0].length != 2) {
            return list.toArray(new int[0][0]);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
            }
        });
        int[] first = intervals[0];
        list.add(first);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= first[1]) {
                first[1] = Math.max(curr[1], first[1]);
            } else {
                first = curr;
                list.add(curr);
            }
        }
        return list.toArray(new int[0][0]);
    }

    private void sortStart(int[][] intervals, int start, int end, int[][] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortStart(intervals, start, mid, temp);
            sortStart(intervals, mid + 1, end, temp);
            mergeSort(intervals, start, mid, end, temp);
        }
    }

    private void mergeSort(int[][] intervals, int start, int mid, int end, int[][] temp) {
        int index = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            temp[index++] = intervals[left][0] <= intervals[right][0] ? intervals[left++] : intervals[right++];
        }
        while (left <= mid) {
            temp[index++] = intervals[left++];
        }
        while (right <= end) {
            temp[index++] = intervals[right++];
        }
        index = 0;
        while (start <= end) {
            intervals[start++] = temp[index++];
        }
    }

}
