package interview.offer;

public class MatchRegx {
    /**
     * 实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
     * 但是与"aa.a"和"ab*a"均不匹配
     * @param str
     * @param pattern
     * @return
     * 注意事项：边界条件
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (pattern.length == 0) {
            return str.length == 0;
        }

        boolean firstChar = str.length != 0 && (pattern[0] == '.' || str[0] == pattern[0]);
        if (pattern.length > 1 && pattern[1] == '*') {
            return match(str, copyChar(pattern, 2)) || (firstChar && match(copyChar(str, 1), pattern));
        } else {
            return firstChar && match(copyChar(str, 1), copyChar(pattern, 1));
        }
    }

    private char[] copyChar(char[] origin,int start){
        char[] res = new char[origin.length-start];
        int index = 0;
        for (int i = start; i < origin.length; i++) {
            res[index++] = origin[i];
        }
        return res;
    }

}
