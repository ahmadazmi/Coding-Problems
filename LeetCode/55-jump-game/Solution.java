class Solution {
    public boolean canJump(int[] nums) {
        // maxDistance refers to the furthest distance we've ever reached in nums
        int maxDistance = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // If index is goes further than maximum distance then reaching goal isn't possible
            if (i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i+nums[i]);
            if (maxDistance >= nums.length-1) return true;
        }
        return true;
    }
}