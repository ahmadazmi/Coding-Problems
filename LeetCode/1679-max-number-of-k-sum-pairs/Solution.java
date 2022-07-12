import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int numOfMaxOperations = 0;
        Arrays.sort(nums);
        int lp = 0, rp = nums.length-1;
        while (lp < rp) {
            int sum = nums[lp]+nums[rp];
            if (sum == k) {
                numOfMaxOperations++;
                lp++; rp--;
            }
            else if (sum < k) lp++;
            else rp--;
        }
        return numOfMaxOperations;
    }
}