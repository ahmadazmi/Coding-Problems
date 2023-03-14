class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1_count = new int[26];
        int[] s2_count = new int[26];
        for (int i = 0; i < s1.length(); i++) s1_count[s1.charAt(i)-'a']++;
        for (int i = 0, j = 0; j < s2.length(); j++) {
            if (s1_count[s2.charAt(j)-'a'] == 0) {s2_count = new int[26]; i = j + 1; continue;}
            s2_count[s2.charAt(j)-'a']++;
            while (s2_count[s2.charAt(i)-'a'] > s1_count[s2.charAt(i)-'a']) s2_count[s2.charAt(i++)-'a']--;
            if (containsPermutation(s1_count, s2_count)) return true;
        }
        return false;
    }

    private boolean containsPermutation(int[] s1_count, int[] s2_count) {
        for (int i = 0; i < 26; i++) if (s1_count[i] != s2_count[i]) return false;
        return true;
    }
}