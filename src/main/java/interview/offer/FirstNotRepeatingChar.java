package interview.offer;

public class FirstNotRepeatingChar {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
     * @param str
     * @return
     * 原理：只有字母，将52个字母的个数分别存储在数组中
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() ==1) {
            return -1;
        }
        int[] chars = new int[52];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c>96){
                c-=6;
            }
            c-=65;
            chars[c] = chars[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c>96){
                c-=6;
            }
            c-=65;
            if (chars[c] == 1){
                return i;
            }
        }

        return -1;
    }
}
