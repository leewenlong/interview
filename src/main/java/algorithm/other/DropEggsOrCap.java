package algorithm.other;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DropEggsOrCap {
    /**
     * 高楼扔鸡蛋(杯子)测试算法
     *
     * @param floor 楼的层数，从0开始
     * @param num   测试的鸡蛋或杯子数量
     * @return 返回尝试的次数
     */
    public int drop(int floor, int num) {
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int res = dropDP(floor, num, map);
        return res;
    }

    private int dropDP(int floor, int number, Map<Pair<Integer, Integer>, Integer> map) {
        if (number == 1) {
            return floor;
        }
        if (floor == 0) {
            return 0;
        }
        Pair pair = new Pair(floor, number);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        int res = floor;
        for (int i = 1; i <= floor; i++) {
            int x = dropDP(i - 1, number - 1, map);//碎了
            int y = dropDP(floor - i, number, map);//没碎
            res = Math.min(res, Math.max(x, y) + 1);
        }
        map.put(new Pair<>(floor, number), res);
        return res;
    }
}
