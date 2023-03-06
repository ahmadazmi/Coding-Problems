class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0, j = 0;
        for (int i = 1; i <= 2000; i++) {
            if (i != arr[j]) missing++;
            else if (j < arr.length-1) j++;
            if (missing == k) return i;
        }
        return missing;
    }
}