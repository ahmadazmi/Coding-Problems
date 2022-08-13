import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(res, s, 0, new ArrayList<>(), "");
        return res;
    }
    
    private void partition(List<List<String>> res, String s, int pos, List<String> currentList, String currentString) {
        if (pos >= s.length()) {
            if (isPalindrome(currentString)) {
                currentList.add(currentString);
                res.add(currentList);
            }
            return;
        }
        if (isPalindrome(currentString)) {
            List<String> newList = new ArrayList<>(currentList);
            newList.add(currentString);
            partition(res, s, pos+1, newList, "" + s.charAt(pos));
            
        }
        partition(res, s, pos+1, currentList, currentString += s.charAt(pos));
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}