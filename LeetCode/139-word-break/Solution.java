import java.util.*;
// Done with the help of my friend Alex on CodePath
// God, do I hate DP...
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for (String word : wordDict) dict.add(word);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0,i+1))) dp[i] = true;
            for (int j = 0; j <= i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(s.substring(j+1, i+1))) dp[i] = true;
            }
        }
        return dp[dp.length-1];
    }
}