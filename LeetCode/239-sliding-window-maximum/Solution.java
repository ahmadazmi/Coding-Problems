class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if (k == 1) return nums;
        int max = Integer.MIN_VALUE, max_count = 0;
        boolean searched_max = false;
        for (int i = 0, j = k-1; j < nums.length; i++, j++) {
            if (max_count == 0) {
                max = Integer.MIN_VALUE;
                for (int n = i; n <= j; n++) {
                    if (max < nums[n]) {max = nums[n]; max_count = 1;}
                    else if (max == nums[n]) max_count++;
                }
                searched_max = true;
            }
            if (!searched_max) {
                if (nums[j] > max) {max = nums[j]; max_count = 1;}
                else if (nums[j] == max) max_count++;
            }
            res[i] = max;
            if (nums[i] == max) {max_count--;}
            searched_max = false;
        }
        return res;
    }
}