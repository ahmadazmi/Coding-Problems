class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                numIslands(grid, visited, i, j);
                numIslands++;
            }
        }
        return numIslands;
    }
    
    private static void numIslands(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        numIslands(grid, visited, i-1, j);
        numIslands(grid, visited, i+1, j);
        numIslands(grid, visited, i, j-1);
        numIslands(grid, visited, i, j+1);
    }
}