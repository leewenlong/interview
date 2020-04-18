package algorithm.leetcode;


public class A60_PermutationSequence {
    public String getPermutation(int n, int k) {
        int product = 1;//n数字个排列的数量为 n!
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            product *= i;
            sb.append(i);
        }
        if (k > product) {
            return "";
        }
        int index;
        k--;//索引从0开始计算
        for (int i = 0; i < n; i++) {
            product /= n - i;// 1234...n 字符串排除第i位后剩余的排列数组的个数
            index = i + k / product;
            if (index != i) {//swap i,index 且从理论上来说index>=i，不会出现index<i的情况
                char c = sb.charAt(index);
                sb.deleteCharAt(index);
                sb.insert(i, c);
            }
            k %= product;
            if (k == 0) {//已经定位到k
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public String getPermutationII(int n, int k) {
        int product = 1;//n数字个排列的数量为 n!
        char[] chars = new char[n];
        for (int i = 1; i <= n; i++) {
            product *= i;
            chars[i - 1] = (char) (i + '0');
        }
        if (k > product) {
            return "";
        }
        int index;
        k--;//索引从0开始计算
        for (int i = 0; i < n; i++) {
            product /= n - i;// 1234...n 字符串排除第i位后剩余的排列数组的个数
            index = i + k / product;
            if (index != i) {//swap i,index 且index>=i，不会出现index<i的情况
                char c = chars[i];
                chars[i] = chars[index];
                chars[index] = c;
            }
            k %= product;
            if (k == 0) {//已经定位到k
                return new String(chars);
            }
        }
        return "";
    }
}
