class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (!isAlphanumeric(s.charAt(i))) {i++; continue;}
            if (!isAlphanumeric(s.charAt(j))) {j--; continue;}
            if (toLowerCase(s.charAt(i++)) != toLowerCase(s.charAt(j--))) return false;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        if (c >= 48 && c <= 57) return true;
        else if (c >= 65 && c <= 90) return true;
        else if (c >= 97 && c <= 122) return true;
        return false;
    }
    
    private char toLowerCase(char c) {
        if (c >= 65 && c <= 90) return (char)(c+32);
        return c;
    }
}