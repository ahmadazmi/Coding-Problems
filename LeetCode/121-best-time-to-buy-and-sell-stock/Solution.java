class Solution {
    public int maxProfit(int[] prices) {
        int highestStockPrice = 0;
        int maxProfit = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            if (highestStockPrice < prices[i]) highestStockPrice = prices[i];
            if (maxProfit < highestStockPrice - prices[i]) maxProfit = highestStockPrice - prices[i];
        }
        return maxProfit;
    }
}