package algorithm.leetcode;

public class A171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null||s.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            res = res*26+(c-'A'+1);
        }
        return res;
    }
}
