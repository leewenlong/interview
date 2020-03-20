package algorithm.leetcode;

public class A66_PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        if (digits[digits.length - 1] == 9) {
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    return digits;
                }
            }
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        }
        return digits;
    }
}
