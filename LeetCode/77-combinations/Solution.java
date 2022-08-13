import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(n, k, res, new ArrayList<Integer>(), 1);
        return res;
    }
    
    private void combine(int n, int k, List<List<Integer>> res, List<Integer> cur, int i) {
        if (i > k) {res.add(cur); return;}
        if (cur.isEmpty()) {
            for (int j = 1; j <= n-k+i; j++) {
                List<Integer> next = new ArrayList<Integer>();
                next.add(j);
                combine(n, k, res, next, i+1);
            }
        }
        else {
            for (int j = cur.get(i-2)+1; j <= n-k+i; j++) {
                List<Integer> next = new ArrayList<Integer>(cur);
                next.add(j);
                combine(n, k, res, next, i+1);
            }
        }
    }
}