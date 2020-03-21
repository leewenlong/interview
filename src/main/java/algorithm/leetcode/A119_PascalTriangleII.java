package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        if (rowIndex == 0) {
            return list;
        }
        for (int i = 1; i <= rowIndex; i++) {
            list.add(0,1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j,list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new A119_PascalTriangleII().getRow(7));
    }
}
