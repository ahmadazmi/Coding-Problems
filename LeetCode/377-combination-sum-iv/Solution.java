import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int combinations = combinationSum4(nums, target, 0, dp);
        return combinations;
    }
    
    private int combinationSum4(int[] nums, int target, int sum, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(sum)) return dp.get(sum);
        if (sum == target) return 1;
        else if (sum > target) return 0;
        int combinations = 0;
        for (int i = 0; i < nums.length; i++) {
            combinations += combinationSum4(nums, target, sum + nums[i], dp);
        }
        dp.put(sum, combinations);
        return combinations;
    }
}