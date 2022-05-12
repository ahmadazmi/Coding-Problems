class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            int m = (i+j)/2;
            if (nums[m] == target) return m;
            // left side is not in ascending order
            if (nums[m] < nums[i]) {
                // check if target is in right side range
                if (target <= nums[j] && target > nums[m]) i = m+1;
                else j = m-1;
            }
            // right side is not in ascending order
            else if (nums[m] > nums[j]) {
                // check if target is in left side range
                if (target >= nums[i] && target < nums[m]) j = m-1;
                else i = m+1;
            }
            // the numbers between i and j are in ascending order
            else {
                if (target < nums[m]) j = m-1;
                else i = m+1;
            }
        }
        return (nums[i] == target)?i:-1;
    }
}