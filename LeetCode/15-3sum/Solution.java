import java.util.*;

class Solution {
    // Time complexity: O(n^2)
    // Solution is similar to solving sorted 2sum problem.
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        int i = 0;
        while (i < nums.length-2) {
            int j = i+1, k = nums.length-1;
            while (j < k) {
                if (nums[j]+nums[k] == -nums[i]) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (k > j && nums[k] == nums[k+1]) k--;
                }
                else if (nums[j]+nums[k] < -nums[i]) {
                    j++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                }
                else {
                    k--;
                    while (k > j && nums[k] == nums[k+1]) k--;
                }
            }
            i++;
            while (i < nums.length-2 && nums[i] == nums[i-1]) i++;
        }
        return triplets;
    }
}