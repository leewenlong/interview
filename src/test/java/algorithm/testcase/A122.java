package algorithm.testcase;

import algorithm.leetcode.A122_BestTimeBuySellStockII;
import org.junit.Assert;
import org.junit.Test;

public class A122 {

    @Test
    public void testMaxProfit(){
        int[] a ={7,1,5,3,6,4};
        int[] b={1,2,3,4};
        int[] c={1,2,1};
        int[] d={4,3,2,1};
        A122_BestTimeBuySellStockII stockII = new A122_BestTimeBuySellStockII();

        Assert.assertEquals(7,stockII.maxProfit(a));
        Assert.assertEquals(3,stockII.maxProfit(b));
        Assert.assertEquals(1,stockII.maxProfit(c));
        Assert.assertEquals(0,stockII.maxProfit(d));
    }
}
