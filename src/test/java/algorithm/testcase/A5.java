package algorithm.testcase;


import algorithm.leetcode.A5_LongestPalindromicSubstring;
import algorithm.leetcode.A6_ZigZagConversion;
import org.junit.Assert;
import org.junit.Test;

public class A5 {

    @Test
    public void testLongestPalindromic(){
        A5_LongestPalindromicSubstring p = new A5_LongestPalindromicSubstring();

        Assert.assertEquals("bab",p.longestPalindrome("babad"));
        Assert.assertEquals("bb",p.longestPalindrome("cbbd"));
    }
}
