import java.util.*;
// Done with the help of my friend Alex Huang on CodePath (He also goes to SBU!)
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
        // [a,p,p,l,e,p,e,n,a,p,p,l,e], ["apple", "pen"]
        // [F,F,F,F,T,F,F,T,F,F,F,F,T] -> TRUE
        
        // [c,a,t,s,a,n,d,o,g], ["cats", "dog", "sand", "and", "cat"]
        // [F,F,T,T,F,F,T,F,F] -> FALSE
        return dp[dp.length-1];
    }
}