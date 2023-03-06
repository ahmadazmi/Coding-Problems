class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, longest = 0;
        int[] counts = new int[127];
        while (j < s.length()) {
            while (j < s.length() && counts[s.charAt(j)] < 1) counts[s.charAt(j++)]++;
            longest = Math.max(longest, j-i);
            if (j < s.length()) counts[s.charAt(j)]++;
            else break;
            while (counts[s.charAt(j)] > 1) counts[s.charAt(i++)]--;
            j++;
        }
        return longest;
    }
}