import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> charMapping = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (charMapping.containsKey(s.charAt(i))) {
                if (charMapping.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else if (!charMapping.containsValue(t.charAt(i))) {
                charMapping.put(s.charAt(i), t.charAt(i));
            }
            else return false;
        }
        return true;
    }
}