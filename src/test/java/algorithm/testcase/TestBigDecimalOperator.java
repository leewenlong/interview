package algorithm.testcase;

import algorithm.other.BigDecimalOperator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestBigDecimalOperator {

    private BigDecimalOperator operator = new BigDecimalOperator();
    private String a = "1423430999945345";
    private String b = "45346464575677567";
    private BigDecimal a1 = new BigDecimal(a);
    private BigDecimal b1 = new BigDecimal(b);
    @Test
    public void testAdd(){

        String add = operator.add(a, b);
        Assert.assertEquals(a1.add(b1).toString(),add);
    }

    @Test
    public void testAddII(){

        String add = operator.addII(a, b);
        Assert.assertEquals(a1.add(b1).toString(),add);
    }

    @Test
    public void testMutiply(){

        String add = operator.multiply(a, b);
        Assert.assertEquals(a1.multiply(b1).toString(),add);
    }

    @Test
    public void testMutiplyII(){

        String add = operator.multiplyII(a, b);
        Assert.assertEquals(a1.multiply(b1).toString(),add);
    }
}
