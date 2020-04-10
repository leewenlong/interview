package algorithm.testcase;

import algorithm.leetcode.A32_LongestValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class A32 {
    @Test
    public void testValid(){
        A32_LongestValidParentheses v = new A32_LongestValidParentheses();
        Assert.assertEquals(8,v.longestValidParentheses("()()(())"));
        Assert.assertEquals(4,v.longestValidParentheses("()()"));
        Assert.assertEquals(0,v.longestValidParentheses("))(("));
        Assert.assertEquals(2,v.longestValidParentheses(")()"));
        Assert.assertEquals(6,v.longestValidParentheses("()(())"));
        Assert.assertEquals(4,v.longestValidParentheses("()((())"));
    }
}
