package algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class A76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        if (s.substring(0, t.length()).equals(t)) {
            return t;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (min > right - left + 1) {
                        min = right - left + 1;
                        start = left;
                    }
                    c = s.charAt(left);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                        if (map.get(c) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
