import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        HashMap<Integer, Integer> leastCoins = new HashMap<>();
        coinChange(coins, amount, leastCoins);
        return leastCoins.get(amount);
    }
    
    private int coinChange(int[] coins, int amount, HashMap<Integer, Integer> leastCoins) {
        if (leastCoins.containsKey(amount)) return leastCoins.get(amount);
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        
        int minCoins = Integer.MAX_VALUE;
        boolean canChange = false;
        for (int coin : coins) {
            int futureCoins = coinChange(coins, amount - coin, leastCoins);
            if (futureCoins < 0) continue;
            minCoins = Math.min(minCoins, futureCoins+1);
            canChange = true;
        }
        if (!canChange) minCoins = -1;
        leastCoins.put(amount, minCoins);
        return minCoins;
    }
}