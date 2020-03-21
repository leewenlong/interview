package algorithm.other;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 算术编码简易实现，仅供学习不可用于实际生产中，
 * 实际生产中必须使用小数点更精确的
 * @see java.math.BigDecimal
 */
public class ArithmeticCoder {
    Map<Character, Pair<Double, Double>> charMap = new HashMap<>();

    public double encode(String s) {

        charMap.clear();
        for (char c : s.toCharArray()) {
            Pair<Double, Double> p = charMap.get(c);
            if (null == p) {
                p = Pair.of(0.0, 1.0);
                charMap.put(c, p);
            } else {
                p.right = p.right + 1;
            }
        }

        //将字符按照遍历顺序依次计算概率并分布在(0,1]之间
        double add = 0;
        for (Map.Entry<Character, Pair<Double, Double>> entry : charMap.entrySet()) {
            Pair<Double, Double> p = entry.getValue();
            p.left = add;
            add += p.right / s.length();
            p.right = add;
        }

        //主要编码算法
        double low = 0;
        double high = 1;
        double temp;
        for (int i = 0; i < s.length(); i++) {
            Pair<Double, Double> p = charMap.get(s.charAt(i));
            temp = low;
            low = low + (high - low) * p.left;
            high = temp + (high - temp) * p.right;
        }
        return (high + low) / 2;//在low与high之间随机选一个值即可
    }


    public String decode(double d, int len) {
        if (charMap.isEmpty()){//
            return null;
        }
        StringBuilder sb = new StringBuilder();

        //概率右值-->字符,可以不用此map，直接用charMap暴力循环
        TreeMap<Double, Character> pMap = new TreeMap<>();
        for (Map.Entry<Character, Pair<Double, Double>> entry : charMap.entrySet()) {
            pMap.put(entry.getValue().right,entry.getKey());
        }

        while (sb.length()<len){
            Character v = pMap.higherEntry(d).getValue();//tree map中key为二叉红黑树，搜索更快
            sb.append(v);
            Pair<Double, Double> pair = charMap.get(v);
            d = (d - pair.left) / (pair.right - pair.left);
        }
        return sb.toString();
    }

    static class Pair<A, B> {
        public A left;
        public B right;

        public Pair(A left, B right) {
            this.left = left;
            this.right = right;
        }

        public static <A, B> Pair<A, B> of(A left, B right) {
            return new Pair<>(left, right);
        }

    }
}
