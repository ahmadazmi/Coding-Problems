class Solution {
    public int removeElement(int[] nums, int val) {
        int left_shift = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) left_shift++;
            else nums[i-left_shift] = nums[i];
        }
        return nums.length-left_shift;
    }
}