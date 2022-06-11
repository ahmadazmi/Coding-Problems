import java.util.*;

class MyQueue {

    Stack<Integer> normalStack;
    Stack<Integer> reverseStack;
    
    public MyQueue() {
        normalStack = new Stack<Integer>();
        reverseStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        normalStack.push(x);
    }
    
    public int pop() {
        if (reverseStack.isEmpty())
            while(!normalStack.isEmpty())
                reverseStack.push(normalStack.pop());
        return reverseStack.pop();
    }
    
    public int peek() {
        if (reverseStack.isEmpty())
            while(!normalStack.isEmpty())
                reverseStack.push(normalStack.pop());
        return reverseStack.peek();
    }
    
    public boolean empty() {
        return (normalStack.isEmpty() && reverseStack.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */