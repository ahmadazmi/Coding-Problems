class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder shiftedStr = new StringBuilder();
        for (int i = shifts.length-2; i >= 0; i--) {
            shifts[i] += shifts[i+1]%26;
        }
        for (int i = 0; i < shifts.length; i++) {
            shiftedStr.append(shiftChar(s.charAt(i), shifts[i]));
        }
        return shiftedStr.toString();
    }
    
    private char shiftChar(char c, int x) {
        x = ((int)c-97+x)%26;
        return (char)(x+97);
    }
}