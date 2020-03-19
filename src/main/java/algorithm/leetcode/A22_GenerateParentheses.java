package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n<1){
            return list;
        }
        next(list,"",0,0,n);

        return list;
    }

    private void next(List<String> list, String s, int left, int right, int n) {
        if (s.length() == 2*n){
            list.add(s);
            return;
        }
        if (left<n){
            next(list,s+'(',left+1,right,n);
        }
        if (right<left){
            next(list,s+'(',left,right+1,n);
        }
    }

}
