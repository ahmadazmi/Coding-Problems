import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++)
            s.push(parseString(s, tokens[i]));
        return s.pop();
    }

    private int parseString(Stack<Integer> s, String c) {
        switch(c) {
            case "+": return s.pop() + s.pop();
            case "-": return - s.pop() + s.pop();
            case "*": return s.pop() * s.pop();
            case "/": return (int)((1.0 / s.pop()) * s.pop());
            default: return Integer.parseInt(c);
        }
    }
}