class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            if (l >= r-1) {
                if (target <= nums[l]) return l;
                else if (target <= nums[r]) return r;
                else return r+1;
            }
            else if (nums[(l+r)/2] < target) l = (l+r)/2;
            else r = (l+r)/2;
        }
        return l;
    }
}