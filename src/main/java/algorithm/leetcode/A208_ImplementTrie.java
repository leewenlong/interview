package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class A208_ImplementTrie {
    class Trie {
        private char c;
        private Map<Character,Trie> children;
        private boolean isEnd;
        /** Initialize your data structure here. */
        public Trie() {
            children = new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (null == word){
                return;
            }
            Trie t = this;
            for (char ch : word.toCharArray()) {
                Trie trie = t.children.get(ch);
                if (trie == null) {
                    trie = new Trie();
                    trie.c = ch;
                    t.children.put(ch,trie);
                }
                t = trie;
            }
            t.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie t = this;
            for (char ch : word.toCharArray()) {
                t = t.children.get(ch);
                if (t == null) {
                    return false;
                }
            }
            return t.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie t = this;
            for (char ch : prefix.toCharArray()) {
                t = t.children.get(ch);
                if (t == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
