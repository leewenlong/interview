package algorithm.testcase;

import algorithm.leetcode.A20_ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class A20 {
    @Test
    public void testValid(){

        A20_ValidParentheses valid = new A20_ValidParentheses();
        Assert.assertTrue(valid.isValid("()"));
        Assert.assertTrue(valid.isValid("()[]{}"));
        Assert.assertFalse(valid.isValid("([)]"));
        Assert.assertTrue(valid.isValid("{[]}"));
        Assert.assertFalse(valid.isValid("){[]}"));
        Assert.assertFalse(valid.isValid("(])"));


    }
}
