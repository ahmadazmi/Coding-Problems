class Solution {
    /**
    * Returns the maximum profit by robbing houses.
    * Solution:
    *   If robber is at house #i, then robber can either rob house #i or
    *   go to house #i+1. Compare the result of either choice and choose the better one.
    *   The solution is done recursively.
    * Optimizing Solution:
    *   Create an array of size nums.length, for an element at position i in this
    *   array, it stores the best result all next robbings at that position.
    *   Aside that, if house at position i contains no money, skip that house.
    */
    public int rob(int[] nums) {
        return rob(nums, 0, new int[nums.length]);
    }
    
    public int rob(int[] nums, int pos, int[] robHouseLookUp) {
        if (pos >= nums.length) return 0;
        if (robHouseLookUp[pos] > 0) return robHouseLookUp[pos];
        int robHouse = 0;
        if (nums[pos] > 0)
            robHouse = rob(nums, pos+2, robHouseLookUp) + nums[pos];
        int skipHouse = rob(nums, pos+1, robHouseLookUp);
        robHouseLookUp[pos] = robHouse>skipHouse?robHouse:skipHouse;
        return robHouseLookUp[pos];
    }
}