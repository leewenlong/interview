package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A20_ValidParentheses {
    Stack<Character> stack = new Stack<>();
    static Map<Character,Character> map = new HashMap<>();
    {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        stack.clear();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsValue(c)) {
                stack.push(c);
                continue;
            }
            if (map.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);

        }
        return stack.isEmpty();
    }
}
