package interview.offer;

import java.util.ArrayList;
import java.util.Collections;

public class CharPermutation {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || "".equals(str)) {
            return list;
        }

        Permutation0(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }
    private void Permutation0(char[] chars,int start,ArrayList<String> list){

        if (start == chars.length){
            String s = new String(chars);
            if (!list.contains(s)){
                list.add(s);
            }
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars,start,i);
            Permutation0(chars,start+1,list);
            swap(chars,start,i);

        }
    }

    private void swap(char[] data,int i,int j){
        if (i==j){
            return;
        }
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
