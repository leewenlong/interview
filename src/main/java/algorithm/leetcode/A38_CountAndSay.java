package algorithm.leetcode;

public class A38_CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "11";
        StringBuilder temp = new StringBuilder();
        for (int i = 3; i <= n; i++) {
            char num = result.charAt(0);
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == num) {
                    count++;
                } else {
                    temp.append(count).append(num);
                    num = result.charAt(j);
                    count = 1;
                }
            }
            temp.append(count).append(num);
            result = temp.toString();
            temp.delete(0, temp.length());
        }
        return result;
    }

}
