package algorithm.leetcode;

import java.util.*;

public class A17_LetterCombinationsOfAPhoneNumber {

    String[] phoneNumber = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() < 1) {
            return result;
        }
        if (!Character.isDigit(digits.charAt(0))) {
            return result;
        }
        int number = (int) digits.charAt(0) - (int) '2';
        LinkedList<String> temp = new LinkedList<>();//存放中间生成数据

        String letters = phoneNumber[number];
        for (int i = 0; i < letters.length(); i++) {
            String str = String.valueOf(letters.charAt(i));
            result.add(str);
        }

        int charAt = 1;//输入数字下标
        while (charAt < digits.length()) {
            temp.clear();
            temp.addAll(result);
            result.clear();
            for (String s : temp) {
                if (!Character.isDigit(digits.charAt(charAt))) {
                    return result;
                }
                number = (int) digits.charAt(charAt) - (int) '2';
                letters = phoneNumber[number];
                for (int k = 0; k < letters.length(); k++) {
                    String str = s + String.valueOf(letters.charAt(k));
                    result.add(str);
                }
            }
            charAt++;
        }

        return result;
    }

    public List<String> letterCombinations_1(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() < 1) {
            return result;
        }
        if (!Character.isDigit(digits.charAt(0))) {
            return result;
        }
        result.add("");//just for first loop
        for (int i = 0; i < digits.length(); i++) {
            int number = (int) digits.charAt(i) - (int) '2';
            String letters = phoneNumber[number];
            while (result.getFirst().length()==i){
                String temp = result.removeFirst();
                for (int j = 0; j < letters.length(); j++) {
                    String str = String.valueOf(letters.charAt(j));
                    result.add(temp+str);
                }
            }
        }
        return result;
    }
}
