class Solution {
    public int findDuplicate(int[] nums) {
        int slowPtr = nums[0];
        int fastPtr = nums[nums[0]];
        // Loop is used to find the cycle
        while (slowPtr != fastPtr) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[nums[fastPtr]];
        }
        // By traversing from slowPtr = 0, when slowPtr == fastPtr we find the duplicate
        slowPtr = 0;
        while (slowPtr != fastPtr) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
        }
        return slowPtr;
    }
}