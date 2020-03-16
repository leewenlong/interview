package interview.offer;

public class Power {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * 原理：快速乘法
     */
    public double Power(double base, int exponent) {
        if (0==base){
            return 0;
        }
        double re = 1;
        if(exponent<0){
            base = 1/base;
            exponent = -exponent;
        }
        while (exponent!=0){
            if ((exponent&1)==1){
                re*=base;
            }
            base*=base;
            exponent >>>=1;
        }
        return re;
    }
}
