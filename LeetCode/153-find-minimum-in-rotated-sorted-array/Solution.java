class Solution {
    public int findMin(int[] nums) {
        // The minimum number would be at an index i, where nums[i-1] > nums[i]
        // We can create a loop where at each iteration, we look at left and right sides and see where min is.
        int i = 0, j = nums.length-1;
        while (i < j) {
            int m = (i+j)/2;
            // Check if number at m is minimum
            if ((m > 0 && nums[m] < nums[m-1]) || m == 0 && (nums[m] < nums[nums.length-1])) return nums[m];
            // If nums[j] is less than nums[m] then our smallest number is within j to m range
            else if (nums[j] < nums[m]) i = m+1;
            else j = m-1;
            
        }
        return nums[i];
    }
}