class OldSolution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 1;
        while (i < nums.length) {
            if (nums[i] + nums[j] == target) break;
            if (j < nums.length-1) {j++;}
            else {i++; j = i+1;}
        }
        return new int[] {i, j};
    }
}