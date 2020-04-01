package algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class A146_LRUCache {
    class LRUCache {
        private final int capacity;
        private Map<Integer, Integer> data = new HashMap<>();
        private LinkedList<Integer> linkedList = new LinkedList<>();

        public LRUCache(int capacity) {
            if (capacity < 0) {
                capacity = 0;
            }
            this.capacity = capacity;

        }

        public int get(int key) {
            if (data.isEmpty()) {
                return -1;
            }
            Integer k = key;
            int res = -1;
            if (data.containsKey(k)) {
                res = data.get(key);
                if (!linkedList.getFirst().equals(k)) {
                    linkedList.remove(k);
                    linkedList.addFirst(k);
                }
            }
            return res;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (data.size() == capacity) {
                if (data.containsKey(key)) {
                    linkedList.remove(new Integer(key));
                } else {
                    data.remove(linkedList.removeLast());
                }
            } else {
                if (data.containsKey(key)) {
                    linkedList.remove(new Integer(key));
                }
            }
            linkedList.addFirst(key);
            data.put(key, value);

        }
    }

    class LRUCacheII extends LinkedHashMap<Integer,Integer> {
        private final int capacity;
        public LRUCacheII(int capacity) {
            super(capacity,0.75f,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size()>capacity;
        }
    }

}
