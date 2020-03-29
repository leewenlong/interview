package algorithm.leetcode;

import java.math.BigDecimal;

public class A43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }
        String result = null;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int product = a * b + carry;
                temp.insert(0, product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                temp.insert(0, carry);
            }
            for (int j = num1.length() - 1; j > i; j--) {
                temp.append(0);
            }
            if (result == null) {
                result = temp.toString();
            } else {
                result = add(result, temp.toString());
            }
        }

        return result;
    }


    public String multiplyII(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int p1 = i + j;
                int p2 = i + j + 1;
                int product = a * b + res[p2];
                res[p2] = product % 10;
                //其实这里可以不用判断p1位是否超过9，如果累加后是2位数，后续还有未计算会自动加上去，
                // 如果后续无未计算数，那就是说最高位是个2位数，转换成字符串最高也是2位数，
                res[p1] += product / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        boolean start = false;
        for (int i = 0; i < res.length; i++) {
            if (!start || res[i] > 0) {
                start = true;
            }
            if (start) {
                result.append(res[i]);
            }
        }
        return result.toString();
    }

    public String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len = Math.min(num1.length(), num2.length());
        int len1 = num1.length() - len;
        int len2 = num2.length() - len;
        for (int i = len - 1; i >= 0; i--) {
            int a = num1.charAt(len1 + i) - '0';
            int b = num2.charAt(len2 + i) - '0';
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }

        if (num1.length() > len) {
            addRemain(num1, sb, carry, len);
        } else if (num2.length() > len) {
            addRemain(num2, sb, carry, len);
        } else if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    private void addRemain(String num1, StringBuilder sb, int carry, int len) {
        for (int i = num1.length() - len - 1; i >= 0; i--) {
            if (carry == 0) {
                sb.insert(0, num1.substring(0, i + 1));
                return;
            }
            int sum = carry + (num1.charAt(i) - '0');
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
    }

    public static void main(String[] args) {
        A43_MultiplyStrings s = new A43_MultiplyStrings();
        String a = "103";
        String b = "98";
        a = "1423430999945345";
        b = "45346464575677567";
        System.out.println(s.add(a, b));
        System.out.println(new BigDecimal(a).add(new BigDecimal(b)).toString().equals(s.add(a, b)));

        System.out.println(s.multiplyII(a, b));

        System.out.println(new BigDecimal(a).multiply(new BigDecimal(b)));
    }
}
