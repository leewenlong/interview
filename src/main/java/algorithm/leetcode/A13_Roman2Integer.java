package algorithm.leetcode;

import java.util.HashMap;

public class A13_Roman2Integer {

    public int romanToInt(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> symb = new HashMap<>();
        symb.put('I', 1);
        symb.put('V', 5);
        symb.put('X', 10);
        symb.put('L', 50);
        symb.put('C', 100);
        symb.put('D', 500);
        symb.put('M', 1000);
        int res = 0;
        char[] chars = s.toCharArray();
        int pre;
        boolean sign = true;
        for (int i = 0; i < chars.length; i++) {
            sign = true;
            pre = symb.get(chars[i]);
            if (i + 1 < chars.length && pre < symb.get(chars[i + 1])) {
                sign = false;
            }
            if (sign) {
                res += pre;
            } else {
                res -= pre;
            }
        }

        return res;
    }
}
