package algorithm.leetcode;

import java.util.Stack;

public class A150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (null == tokens || tokens.length ==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            switch (s) {
                case "*":
                    res = stack.pop() * stack.pop();
                    stack.push(res);
                    break;
                case "/":
                    Integer pop = stack.pop();
                    res = stack.pop() / pop;
                    stack.push(res);
                    break;
                case "+":
                    res = stack.pop() + stack.pop();
                    stack.push(res);
                    break;
                case "-":
                    pop = stack.pop();
                    res = stack.pop() - pop;
                    stack.push(res);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }

        }
        return stack.pop();
    }
}
