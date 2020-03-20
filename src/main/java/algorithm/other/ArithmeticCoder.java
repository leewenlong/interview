package algorithm.other;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticCoder {
    Map<Character, Pair<Double, Double>> map = new HashMap<>();

    public double encode(String s) {

        for (char c : s.toCharArray()) {
            Pair<Double, Double> p = map.get(c);
            if (null == p) {
                p = Pair.of(0.0, 1.0);
                map.put(c, p);
            } else {
                p.right = p.right + 1;
            }
        }

        double add = 0;
        for (Map.Entry<Character, Pair<Double, Double>> entry : map.entrySet()) {
            Pair<Double, Double> p = entry.getValue();
            p.left = add;
            add += p.right / s.length();
            p.right = add;
        }


        double low = 0;
        double high = 1;
        double temp;
        for (int i = 0; i < s.length(); i++) {
            Pair<Double, Double> p = map.get(s.charAt(i));
            temp = low;
            low = low + (high - low) * p.left;
            high = temp + (high - temp) * p.right;
        }
        return (high + low) / 2;
    }

    public static void main(String[] args) {
        String a = "aabfffcdef";
        ArithmeticCoder coder = new ArithmeticCoder();
        double en = coder.encode(a);
        System.out.println(en);
        System.out.println(coder.decode(en, a.length()));
    }

    public String decode(double d, int total) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            for (Map.Entry<Character, Pair<Double, Double>> entry : map.entrySet()) {
                Pair<Double, Double> pair = entry.getValue();
                if (pair.left < d && pair.right > d) {
                    sb.append(entry.getKey());
                    //TODO 结束条件？
                    if (sb.length() == total) {
                        return sb.toString();
                    }
                    d = (d - pair.left) / (pair.right - pair.left);
                }
            }
        }
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
