import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int left = num, right = num;
                while (set.remove(--left));
                while (set.remove(++right));
                res = Math.max(res, right-left-1);
            }
        }
        return res;
    }
}