import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            List<String> letters = getLetters(digits.charAt(i));
            if (combinations.isEmpty()) combinations = new ArrayList<>(letters);
            else {
                int j = combinations.size()-1;
                while (j >= 0) {
                    String appendTo = combinations.remove(j);
                    for (String letter : letters) {
                        combinations.add(appendTo+letter);
                    }
                    j--;
                }
            }
        }
        return combinations;
    }
    
    private List<String> getLetters(char digit) {
        switch(digit) {
            case '2': return Arrays.asList("a","b","c");
            case '3': return Arrays.asList("d","e","f");
            case '4': return Arrays.asList("g","h","i");
            case '5': return Arrays.asList("j","k","l");
            case '6': return Arrays.asList("m","n","o");
            case '7': return Arrays.asList("p","q","r","s");
            case '8': return Arrays.asList("t","u","v");
            case '9': return Arrays.asList("w","x","y","z");
        }
        return null;
    }
}