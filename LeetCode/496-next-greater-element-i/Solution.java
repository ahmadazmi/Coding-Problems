import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterArray = new int[nums1.length];
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            int j = i;
            while (j < nums2.length && nums2[i] >= nums2[j]) j++;
            if (j >= nums2.length) nextGreaterMap.put(nums2[i], -1);
            else nextGreaterMap.put(nums2[i], nums2[j]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nextGreaterArray[i] = nextGreaterMap.get(nums1[i]);
        }
        return nextGreaterArray;
    }
}