class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int l = 0, r = 0;
        int[] count = new int[3];
        while (l < s.length()-2) {
            while (r < s.length() && (count[0] < 1 || count[1] < 1 || count[2] < 1)) {
                count[s.charAt(r++) - 'a']++;
            }
            if ((count[0] > 0 && count[1] > 0 && count[2] > 0)) r--;
            if (r >= s.length()) break;
            res += s.length() - r;
            r++;
            count[s.charAt(l++) - 'a']--;
        }
        return res;
    }
    
}