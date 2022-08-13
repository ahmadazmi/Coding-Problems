class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        return minPathCostAtIdx(grid, dp, grid.length-1, grid[0].length-1);
    }
    
    private int minPathCostAtIdx(int[][] grid, int[][] dp, int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if (i > 0)
            top = minPathCostAtIdx(grid, dp, i-1, j);
        if (j > 0)
            left = minPathCostAtIdx(grid, dp, i, j-1);
        
        dp[i][j] = Math.min(top, left);
        if (dp[i][j] == Integer.MAX_VALUE) dp[i][j] = 0;
        dp[i][j] += grid[i][j];
        // Uncomment below to see how recursion behaves at each iteration
        // System.out.println("i: "+i+", j: "+j+" | top: "+top+", left: "+left+" | dp[i][j]: "+dp[i][j]);
        return dp[i][j];
    }
}