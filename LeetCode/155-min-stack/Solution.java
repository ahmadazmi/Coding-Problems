import java.util.*;

class MinStack {
    
    Stack<Integer> normalStack;
    Stack<Integer> minStack;
    
    public MinStack() {
        normalStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        normalStack.push(val);
        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = normalStack.pop();
        if (val == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return normalStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */