import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> rem = new ArrayList<>();
        for (int num : nums) rem.add(num);
        permute(nums, res, new ArrayList<>(), rem);
        return res;
    }
    
    private void permute(int[] nums, List<List<Integer>> res, ArrayList<Integer> cur, ArrayList<Integer> rem) {
        if (rem.isEmpty()) {res.add(cur); return;}
        for (int i = 0; i < rem.size(); i++) {
            ArrayList<Integer> newCur = new ArrayList<>();
            for (int num : cur) newCur.add(num);
            ArrayList<Integer> newRem = new ArrayList<>();
            for (int num : rem) newRem.add(num);
            newCur.add(newRem.remove(i));
            permute(nums, res, newCur, newRem);
        }
    }
}