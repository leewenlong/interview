package algorithm.other;

public class ManacherAlgorithm {

    public static String manacher(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        char[] padding = new char[input.length() * 2 + 3];
        int index = 2;//填充字符串的索引
        padding[0] = '^';//仅仅是为了不同于最后一个填充字符,只需要第一个与最后一个字符不相同即可
        for (int i = 0; i < input.length(); i++) {
            padding[index] = input.charAt(i);
            index += 2;//其它的数据默认填充为空('\0')
        }
        index = 2;//因为前两个都是填充字符，真实的可以直接从2开始比较

        int[] radius = new int[padding.length];//填充字条对应的最大回文半径
        radius[0] = radius[1] = 1;
        int maxLen = 1;//最大回文半径
        int center = 1;//最大回文半径对应的填充下标
        int right = 2;//以当前位置和之前radius计算出的最右边界
        int nearstCenterIndexOfRight = 2;//离右边界最近一个的回文中心下标
        while (index < padding.length - 1) {//一定注意边界条件，因为最后两个是填充非真实数据，需要提前结束，否则会溢出
            radius[index] = right > index ? Math.min(radius[2 * nearstCenterIndexOfRight - index], right - index) : 1;
            while (padding[index - radius[index]] == padding[index + radius[index]]) {
                radius[index]++;
            }
            if (maxLen < radius[index]) {
                maxLen = radius[index];
                center = index;
            }
            if (right < index + radius[index]) {
                right = index + radius[index];
                nearstCenterIndexOfRight = index;
            }
            index++;
        }

        int start = (center - maxLen) / 2;
        return input.substring(start, start + maxLen - 1);
    }
}
