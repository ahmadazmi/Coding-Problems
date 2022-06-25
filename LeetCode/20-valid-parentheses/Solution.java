import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else if (s.charAt(i) == '{') stack.push('{');
            else if (s.charAt(i) == '[') stack.push('[');
            else if (stack.isEmpty()) return false;
            else if (s.charAt(i) == ')' && stack.pop() == '(');
            else if (s.charAt(i) == '}' && stack.pop() == '{');
            else if (s.charAt(i) == ']' && stack.pop() == '[');
            else return false;
        }
        return stack.isEmpty();
    }
}