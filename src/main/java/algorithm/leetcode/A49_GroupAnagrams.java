package algorithm.leetcode;

import java.util.*;

public class A49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length==0) {
            return result;
        }
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String t = new String(chars);
            List<String> list = map.get(t);
            if (null != list){
                list.add(strs[i]);
            }else {
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(t,list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
