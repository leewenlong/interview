package algorithm.other;

public class BigDecimalOperator {
    /**
     * 未处理符号及未验证是否是数字，其实每一次可以最多取9个长度
     * (9个长度可以保证跟<10的数相乘不会溢出)的数字跟单个数字相乘
     *
     * @param a
     * @param b
     * @return
     */
    public String multiply(String a, String b) {
        String result = null;
        for (int i = a.length() - 1; i >= 0; i--) {
            int m = a.charAt(i) - '0';
            if (m == 0) {
                continue;
            }
            int carry = 0;
            StringBuilder t = new StringBuilder();
            for (int j = b.length() - 1; j >= 0; j--) {
                int n = b.charAt(j) - '0';
                int product = m * n + carry;
                t.insert(0, product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                t.insert(0, carry);
            }
            for (int j = a.length() - 1; j > i; j--) {
                t.append(0);
            }

            if (result != null) {
                result = add(result, t.toString());
            } else {
                result = t.toString();
            }
        }
        return result;
    }

    /**
     * 每一次最多取8个长度(8个长度可以保证跟<10的数相乘不会溢出)的数字跟单个数字相乘
     *
     * @param a
     * @param b
     * @return
     */
    public String multiplyII(String a, String b) {
        int bytes = 8;
        String result = null;
        int lenA = a.length();
        for (int i = a.length() - 1; i >= 0; i--) {
            int m = a.charAt(i) - '0';
            if (m == 0) {
                continue;
            }
            StringBuilder temp = null;
            for (int j = 0; j < b.length(); j = j + bytes) {
                int minLen = Math.min(bytes, b.length() - j);
                String subB = b.substring(b.length() - minLen - j, b.length() - j);
                int n = Integer.parseInt(subB);
                StringBuilder product = new StringBuilder(String.valueOf(m * n));
                if (temp == null) {
                    temp = product;
                } else {
                    for (int k = 0; k < j; k++) {
                        product.append(0);
                    }
                    temp = new StringBuilder(add(temp.toString(), product.toString()));
                }
            }

            for (int j = lenA - 1; j > i; j--) {
                temp.append(0);
            }
            if (result != null) {
                result = add(result, temp.toString());
            } else {
                result = temp.toString();
            }
        }
        return result;
    }

    /**
     * 单个数字循环相加
     *
     * @param a
     * @param b
     * @return
     */
    public String add(String a, String b) {

        StringBuilder result = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.min(lenA, lenB);
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < len; i++, lenA--, lenB--) {
            int m = a.charAt(lenA - 1) - '0';
            int n = b.charAt(lenB - 1) - '0';
            sum = m + n + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
        }
        lenA = a.length() - len;
        lenB = b.length() - len;
        if (lenA > 0) {
            String remainPrefix = getRemainPrefix(a, lenA, carry);
            result.insert(0, remainPrefix);
        } else if (lenB > 0) {
            String remainPrefix = getRemainPrefix(b, lenB, carry);
            result.insert(0, remainPrefix);
        } else {
            if (carry > 0) {
                result.insert(0, carry);
            }
        }
        return result.toString();
    }

    /**
     * 整形的最大值的最大长度为10，所以两个长度为9个长度的数字相加无论如何都不会溢出
     *
     * @param a
     * @param b
     * @return
     */
    public String addII(String a, String b) {

        int bytes = 9;
        StringBuilder result = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.min(lenA, lenB);
        int carry = 0;
        int m, n, sum;

        String subA = a.substring(lenA - len);
        String subB = b.substring(lenB - len);
        int saLen = subA.length();
        int sbLen = subB.length();

        for (int i = 0; i < len; i = i + bytes) {
            int minLen = Math.min(bytes, len - i);
            m = Integer.parseInt(subA.substring(saLen - i - minLen, saLen - i));
            n = Integer.parseInt(subB.substring(sbLen - i - minLen, sbLen - i));
            sum = m + n + carry;

            String s = String.valueOf(sum);
            if (s.length() > minLen) {
                carry = s.charAt(0) - '0';
                result.insert(0, s.substring(1));
            } else {
                carry = 0;
                result.insert(0, s);
            }
        }
        lenA = a.length() - len;
        lenB = b.length() - len;
        if (lenA > 0) {
            String remainPrefix = getRemainPrefix(a, lenA, carry);
            result.insert(0, remainPrefix);
        } else if (lenB > 0) {
            String remainPrefix = getRemainPrefix(b, lenB, carry);
            result.insert(0, remainPrefix);
        } else {
            if (carry > 0) {
                result.insert(0, carry);
            }
        }
        return result.toString();
    }

    private String getRemainPrefix(String s, int len, int carry) {
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (carry == 0) {
                sb.insert(0, s.substring(0, i + 1));
                break;
            }
            int t = s.charAt(i) - '0';
            int sum = t + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
