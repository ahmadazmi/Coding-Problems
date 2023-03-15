class Solution {
    public int countVowelSubstrings(String word) {
        int i = 0, j = 0, ways = 0;
        while (j < word.length()) {
            while (i < word.length() && !isVowel(word.charAt(i))) i++;
            j = i;
            while (j < word.length() && isVowel(word.charAt(j))) j++;
            if (i < j) ways += countVowelWindowSubstrings(word, i, j);
            i = j;
        }
        return ways;
    }

    private int countVowelWindowSubstrings(String word, int i, int j) {
        int[] counts = new int[26];
        int ways = 0, k = i;
        while (k < j) {
            while (k < j && !validSubstring(counts)) counts[word.charAt(k++)-'a']++;
            while (validSubstring(counts)) {
                ways += (j-k+1);
                counts[word.charAt(i++)-'a']--;
            }
        }
        return ways;
    }

    private boolean validSubstring(int[] c) {
        return c[0] > 0 && c[4] > 0 && c[8] > 0 && c[14] > 0 && c[20] > 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}