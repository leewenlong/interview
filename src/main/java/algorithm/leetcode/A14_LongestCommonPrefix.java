package algorithm.leetcode;

import java.util.Arrays;

public class A14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length < 1) {
            return sb.toString();
        }
        Arrays.sort(strs);
        sb.append(strs[0]);
        for (int i = strs.length - 1; i > 0; i--) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (j >= sb.length()) {
                    break;
                }
                if (sb.charAt(j) != strs[i].charAt(j)) {
                    sb.delete(j, sb.length());
                    break;
                }
            }
        }
        return sb.toString();
    }

}
