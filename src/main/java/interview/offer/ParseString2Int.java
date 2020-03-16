package interview.offer;

public class ParseString2Int {
    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     * @param str
     * @return
     * 注意：整数的上下限
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        boolean isNeg = false;
        int limit = Integer.MAX_VALUE;
        int result = 0;
        int i = 0;
        char c = str.charAt(0);
        if (c == '-') {
            isNeg = true;
            limit = Integer.MIN_VALUE;
            i++;
        } else if (c == '+') {
            i++;
        }
        while (i < len) {
            c = str.charAt(i);
            if (c < 48 || c > 57) {
                return 0;
            }
            int power = (len - i - 1);
            int part = 0;
            if (isNeg) {
                part += (c - 48) * Math.pow(10, power);
                if (result < limit + part) {
                    return 0;
                }
                result -= part;
            } else {
                part += (c - 48) * Math.pow(10, power);
                if (result > limit - part) {
                    return 0;
                }
                result += part;
            }
            i++;
        }

        return result;
    }
}
