package algorithm.other;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {
    private char root ;
    private Map<Character,TrieTree> children;
    private boolean isValue;

    public TrieTree(){
        root = '\0';
        children = new HashMap<>();
    }
    private TrieTree(char c){
        root = c;
        children = new HashMap<>();
    }
    public void put(String s){
        if (s!=null){
            TrieTree tt = this;
            for (char c : s.toCharArray()) {
                TrieTree ch = tt.children.get(c);
                if (null!=ch){
                    tt = ch;
                    continue;
                }
                ch = new TrieTree(c);
                tt.children.put(c,ch);
                tt = ch;
            }
            tt.isValue = true;
        }
    }

    public boolean search(String s) {
        TrieTree tt = this;
        for (char c : s.toCharArray()) {
            tt = tt.children.get(c);
            if (tt == null) {
                return false;
            }
        }
        return tt.isValue;
    }
    public boolean startWith(String s) {
        TrieTree tt = this;
        for (char c : s.toCharArray()) {
            tt = tt.children.get(c);
            if (tt == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TrieTree tt = new TrieTree();
        tt.put("abcd");
        tt.put("apple");
        tt.put("aa");
        tt.put("applepen");
        tt.put("cdef");

        System.out.println(tt.search("aa"));
        System.out.println(tt.search("abc"));
        System.out.println(tt.startWith("ae"));
        System.out.println(tt.startWith("appl"));
    }
}
