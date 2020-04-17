package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length != 2) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        int[][] res = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = Arrays.copyOfRange(intervals[i], 0, 2);
        }
        res[intervals.length] = newInterval;
        Arrays.sort(res, (i, j) -> i[0] - j[0]);
        int[] first = res[0];
        list.add(first);
        for (int i = 1; i < res.length; i++) {
            int[] curr = res[i];
            if (curr[0] <= first[1]) {
                first[1] = Math.max(curr[1], first[1]);
            } else {
                first = curr;
                list.add(first);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
