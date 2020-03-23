package algorithm.leetcode;

public class A168_ExcelSheetColumnNumber {
    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        char c;
        while (n!=0) {
            int t = (--n) % 26;
            c = (char) (t + 'A');
            sb.append(c);
            n = n / 26;
        }

        return sb.reverse().toString();
    }
}
