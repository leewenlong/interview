package algorithm.testcase;

import algorithm.other.ArithmeticCoder;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

public class TestArithmeticCoder {
    @Test
    public void testEncodeAndDecode(){
        String a = "aabfffcdef";
        ArithmeticCoder coder = new ArithmeticCoder();
        double en = coder.encode(a);
        Assert.assertTrue(en >0 && en<1);
        System.out.println(en);
        Assert.assertEquals(coder.decode(en, a.length()),a);
    }

    public static void main(String[] args) {
        TreeMap<Double, String> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(i+0.1 ,i+"");
        }
        System.out.println(treeMap);
        System.out.println(treeMap.lowerEntry(5.5));
    }
}
