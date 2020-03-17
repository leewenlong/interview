package algorithm.leetcode;

public class A6_ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || numRows < 2) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        boolean neg = false;//反序
        for (int i = 0; i < s.length(); ) {
            if (neg) {
                for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                    sb[j].append(s.charAt(i++));
                }
            } else {
                for (int j = 0; j < numRows && i < s.length(); j++) {
                    sb[j].append(s.charAt(i++));
                }
            }
            neg = !neg;
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
