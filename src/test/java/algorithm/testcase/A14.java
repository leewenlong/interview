package algorithm.testcase;

import algorithm.leetcode.A14_LongestCommonPrefix;
import org.junit.Assert;
import org.junit.Test;

public class A14 {

    @Test
    public void testLongestCommonPrefix() {
        String[] a = {"a","ab"};
        String[] b = {"flower","flow","flight"};
        A14_LongestCommonPrefix prefix = new A14_LongestCommonPrefix();
        Assert.assertEquals("a",prefix.longestCommonPrefix(a));
        Assert.assertEquals("fl",prefix.longestCommonPrefix(b));

    }
}
