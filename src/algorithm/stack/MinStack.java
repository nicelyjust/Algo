package algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 复杂度为O(1)
 */
public class MinStack {



    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);

        System.out.println(minStack.min());
        minStack.pop();
        minStack.min();
    }

    /** initialize your data structure here. */
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Integer pop = stack.pop();
        if (pop.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
