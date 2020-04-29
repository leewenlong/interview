package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k > n) {
            return list;
        }
        int[] temp = new int[k];
        int index = 0;
        while (index >= 0) {
            temp[index]++;
            if (temp[index] > n) {
                index--;
            } else if (index == k - 1) {
                List<Integer> t = new ArrayList<>(k);
                for (int i : temp) {
                    t.add(i);
                }
                list.add(t);
            } else {
                index++;
                temp[index] = temp[index - 1];
            }
        }
        return list;
    }
}
