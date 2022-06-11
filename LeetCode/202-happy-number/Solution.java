import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> cycle = new HashSet<Integer>();
        while (n != 1) {
            int squareSum = 0;
            while (n > 0) {
                squareSum += Math.pow(n%10, 2);
                n /= 10;
            }
            n = squareSum;
            if (!cycle.add(n)) return false;
        }
        return true;
    }
}