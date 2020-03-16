package interview.offer;

public class Add2NumWithoutArithmetic {
    public static void main(String[] args) {
        System.out.println(new Add2NumWithoutArithmetic().Add(-3,4));
    }
    /**
     * 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }
        int xor;
        do {
            xor = num1 ^ num2;//非进位累加，异或只有当两个不同时才为1
            num1 = (num1 & num2) << 1;//进位
            num2 = xor;
        } while (num1 != 0);
        return num2;
    }
}
