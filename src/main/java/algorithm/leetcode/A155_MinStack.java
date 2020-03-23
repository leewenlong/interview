package algorithm.leetcode;

import java.util.Stack;

public class A155_MinStack {
    class MinStack {

        int min = Integer.MIN_VALUE;
        Stack<Integer> data = null;
        public MinStack() {
            data = new Stack<>();
        }

        public void push(int x) {
            if (x<=min){
                data.push(min);
                min = x;
            }
            data.push(x);
        }

        public void pop() {
            if (!data.isEmpty()){
                if (data.pop()==min){
                    min = data.pop();
                }
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
