package algorithm.leetcode;

import javafx.util.Pair;

import java.util.*;

public class A127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        if (!wordList.contains(endWord)){
            return 0;
        }
        //缺少一个字符的转换字符串 ---> wordlist中所有匹配字符串
        Map<String,List<String>> combo = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < len; i++) {
                String n = s.substring(0, i) + ' ' + s.substring(i + 1);
                List<String> transform = combo.getOrDefault(n, new ArrayList<>());
                transform.add(s);
                combo.put(n,transform);
            }
        }
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(beginWord,1));
        visited.add(beginWord);
        while (!queue.isEmpty()){
            Pair<String, Integer> pair = queue.remove();
            String key = pair.getKey();
            for (int i = 0; i < len; i++) {
                String n = key.substring(0, i) + ' ' + key.substring(i + 1);
                for (String word : combo.getOrDefault(n,new ArrayList<>())) {//已经匹配上之前的字符串
                    if (word.equals(endWord)){
                        return pair.getValue()+1;
                    }
                    if (!visited.contains(word)){
                        visited.add(word);
                        queue.add(new Pair<>(word,pair.getValue()+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        String[] s = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new A127_WordLadder().ladderLength(a,b, Arrays.asList(s)));
    }
}
