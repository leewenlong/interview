package interview.offer;

import java.util.Stack;

public class ContainsMinNumStack {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（
     * 时间复杂度应为O（1））
     *
     */
    Stack<Integer> min = new Stack<>();
    Stack<Integer> data = new Stack<>();
    public void push(int node) {
        data.push(node);
        if (!min.isEmpty()&&min.peek()<=node){
            min.push(min.peek());
        }else {
            min.push(node);
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
