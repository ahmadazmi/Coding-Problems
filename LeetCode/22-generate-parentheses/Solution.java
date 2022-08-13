import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(res, n, n, "");
        return res;
    }
    
    private void generateParenthesis(List<String> res, int open, int close, String current) {
        if (open == 0 && close == 0) {res.add(current); return;}
        if (open > 0)
            generateParenthesis(res, open - 1, close, current + "(");
        if (close > open)
            generateParenthesis(res, open, close - 1, current + ")");
    }
}