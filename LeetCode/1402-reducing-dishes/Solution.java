import java.util.*;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int max = 0, crnt = 0, inc = 0, i = 0;
        Arrays.sort(satisfaction);
        while (i < satisfaction.length && satisfaction[i] < 0) i++;
        for (int j = i; j < satisfaction.length; j++) {
            inc += satisfaction[j];
            crnt += satisfaction[j]*(j-i+1);
        }
        max = Math.max(max, crnt);
        for (int j = i-1; j >= 0; j--) {
            inc += satisfaction[j];
            crnt += inc;
            max = Math.max(max, crnt);
        }
        return max;
    }
}