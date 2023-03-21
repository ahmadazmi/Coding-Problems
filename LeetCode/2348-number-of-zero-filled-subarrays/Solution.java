/*
 * Faster Solution (not mine):
 * class Solution {
 *		public long zeroFilledSubarray(int[] nums) {
 *			long count = 0;
 *			for (int i = 0, j = -1, n = nums.length; i < n; i++) {
 *				if (nums[i] != 0) j = i;
 *				else count += i-j;
 *			}
 *			return count;
 *		}
 *	}
 */

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {i++; continue;}
            long length = 0;
            while (i < nums.length && nums[i++] == 0) length++;
            count += length * (length + 1) / 2;
        }
        return count;
    }
}