package algorithm.other;

import java.util.*;

public class RandomRedEnvelope {
    public static void main(String[] args) {
        RandomRedEnvelope redEnvelope = new RandomRedEnvelope();
        int[] random = redEnvelope.random(9, 3);
        System.out.println(Arrays.toString(random));
        int[] ints = redEnvelope.random1(10, 4);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 微信抢红包算法，二倍均值法
     * @param total 总金额，单位为分
     * @param count 人数
     * @return
     */
    public int[] random(int total,int count) {
        if (total < count) {
            return null;
        }
        int[] result = new int[count];
        int index = 0;
        Random random = new Random();
        while (count > 1) {
            int temp = random.nextInt(total * 2) / count;
            temp = temp == 0 ? 1 : temp;
            result[index++] = temp;
            total -= temp;
            count--;
        }
        result[index] = total;//最后一人

        return result;
    }

    /**
     * 线段分隔法
     * @param total
     * @param count
     * @return
     */
    public int[] random1(int total,int count) {
        if (total < count) {
            return null;
        }
        int[] result = new int[count];
        Random random = new Random();
        Set<Integer> temp = new TreeSet<>();//长度为n的线段平均分成m段，包含0与长度
        temp.add(0);
        while (temp.size() < count) {
            temp.add(random.nextInt(total));
        }
        temp.add(total);
        int index = 0;
        Iterator<Integer> iterator = temp.iterator();
        Integer pre = iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            result[index++] = next - pre;
            pre = next;
        }
        return result;
    }
}
