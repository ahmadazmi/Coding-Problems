import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int k = j+1, l = nums.length-1;
                while (k < l) {
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++; l--;
                        while (k < l && nums[k] == nums[k-1]) k++;
                        while (l > k && nums[l] == nums[l+1]) l--;
                    }
                    else if (sum < target) {
                        k++;
                        while (k < l && nums[k] == nums[k-1]) k++;
                    }
                    else {
                        l--;
                        while (l > k && nums[l] == nums[l+1]) l--;
                    }
                }
                while (j < nums.length-2 && nums[j] == nums[j+1]) j++;
            }
            while (i < nums.length-3 && nums[i] == nums[i+1]) i++;
        }
        return quadruplets;
    }
}