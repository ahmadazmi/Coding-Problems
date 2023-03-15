class Solution {
    public String minWindow(String s, String t) {
        int[] t_count = new int[52];
        int[] s_count = new int[52];
        int i = 0, j = 0, minLeft = 0, minRight = s.length(), minWindow = Integer.MAX_VALUE;
        for (int k = 0; k < t.length(); k++) t_count[charToInt(t.charAt(k))]++;
        while (i < s.length() && minWindow > t.length()-1) {
            while (j < s.length() && !isValidWindow(t_count, s_count))
                s_count[charToInt(s.charAt(j++))]++;
            if (!isValidWindow(t_count, s_count)) break;
            while (i < j && isValidWindow(t_count, s_count))
                s_count[charToInt(s.charAt(i++))]--;
            if (1+j-i < minWindow) {minLeft = i-1; minRight = j; minWindow = 1+j-i;}
        }
        if (minWindow == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minRight);
    }

    private boolean isValidWindow(int[] t_count, int[] s_count) {
        for (int i = 0; i < 52; i++)
            if (t_count[i] > 0 && s_count[i] < t_count[i]) return false;
        return true;
    }

    private int charToInt(char c) {
        return c >= 97 ? c-71 : c-65;
    }
}