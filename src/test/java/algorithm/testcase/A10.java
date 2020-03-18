package algorithm.testcase;

import algorithm.leetcode.A10_RegularExpressionMatching;
import org.junit.Assert;
import org.junit.Test;

public class A10 {
    @Test
    public void testRegx(){

        A10_RegularExpressionMatching regx = new A10_RegularExpressionMatching();
        Assert.assertFalse(regx.isMatch("aa","a"));
        Assert.assertTrue(regx.isMatch("aa","a*"));
        Assert.assertTrue(regx.isMatch("ab",".*"));
        Assert.assertTrue(regx.isMatch("aab","c*a*b"));
        Assert.assertFalse(regx.isMatch("mississippi","mis*is*p*."));
        Assert.assertFalse(regx.isMatch("ab",".*c"));
        Assert.assertTrue(regx.isMatch("",".*"));

    }
}
