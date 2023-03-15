class Solution {
    public int strStr(String haystack, String needle) {
        int limit = haystack.length() - needle.length();
        for (int i = 0; i <= limit; i++)
            if (matches(i, haystack, needle))
                return i;
        return -1;
    }

    private boolean matches(int i, String s1, String s2) {
        int j = 0;
        while (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {i++; j++;}
        return j >= s2.length();
    }
}