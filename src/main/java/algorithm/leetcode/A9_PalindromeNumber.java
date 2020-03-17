package algorithm.leetcode;

public class A9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {//一定特别注意为最后一位是0和本身是0的情况
            return false;
        }
        int left = x;
        int right = 0;
        while (left > right) {
            right = right * 10 + left % 10;
            left = left / 10;
        }
        return left == right || left == right / 10;
    }
}
