import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void subsets(List<List<Integer>> res, List<Integer> cur, int[] nums, int i) {
        res.add(cur);
        for (; i < nums.length; i++) {
            List<Integer> next = new ArrayList<Integer>(cur);
            next.add(nums[i]);
            subsets(res, next, nums, i+1);
        }
    }
}