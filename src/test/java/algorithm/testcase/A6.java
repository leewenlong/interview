package algorithm.testcase;


import algorithm.leetcode.A6_ZigZagConversion;
import org.junit.Assert;
import org.junit.Test;

public class A6 {

    @Test
    public void testZigZag(){
        A6_ZigZagConversion conversion = new A6_ZigZagConversion();

        String t = "PAYPALISHIRING";
        Assert.assertEquals("PAHNAPLSIIGYIR",conversion.convert(t,3));
        Assert.assertEquals("PINALSIGYAHRPI",conversion.convert(t,4));
        Assert.assertEquals("acb",conversion.convert("abc",2));
    }
}
