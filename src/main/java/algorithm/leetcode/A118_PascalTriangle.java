package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> last = result.get(i - 1);
            temp.add(last.get(0));
            for (int j = 0; j < last.size() - 1; j++) {
                temp.add(last.get(j) + last.get(j + 1));
            }
            temp.add(last.get(last.size() - 1));

            result.add(temp);
        }

        return result;
    }
}
