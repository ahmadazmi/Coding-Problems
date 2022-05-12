import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> unique_nums_set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!unique_nums_set.add(nums[i])) return true;
        }
        return false;
    }
}