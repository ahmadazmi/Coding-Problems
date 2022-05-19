class OldSolution {
    public boolean canJump(int[] nums) {
        // If an element at X is true then it means reaching goal is impossible
        boolean[] failedJumpLookUp = new boolean[nums.length];
        // Call a recursive canJump() method (method overloading)
        return canJump(nums, 0, failedJumpLookUp);
    }
    
    public boolean canJump(int[] nums, int jumpIndex, boolean[] failedJumpLookUp) {
        if (jumpIndex >= nums.length-1) return true;
        for (int i = nums[jumpIndex]; i > 0; i--) {
            if ((jumpIndex+i) >= nums.length-1) return true;
            else if (failedJumpLookUp[jumpIndex+i]) continue;
            else if (canJump(nums, jumpIndex+i, failedJumpLookUp)) return true;
            else failedJumpLookUp[jumpIndex+i] = true;
        }
        return false;
    }
}