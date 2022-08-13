import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> islands = new HashMap<Integer, Integer>();
        int islandNum = 2;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) continue;
                int area = traverseIsland(grid, i, j, islandNum);
                islands.put(islandNum, area);
                maxArea = Math.max(maxArea, area);
                islandNum++;
            }
        }
        
        // Traverse grid again, turn every 0 into a 1 and check maximum area island
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) continue;
                int area = 1;
                HashSet<Integer> neighbors = new HashSet<Integer>();
                if (i > 0) neighbors.add(grid[i-1][j]);
                if (i < grid.length-1) neighbors.add(grid[i+1][j]);
                if (j > 0) neighbors.add(grid[i][j-1]);
                if (j < grid[0].length-1) neighbors.add(grid[i][j+1]);
                for (int k : neighbors) {
                    if (k == 0) continue;
                    area += islands.get(k);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    
    private int traverseIsland(int[][] grid, int i, int j, int islandNum) {
        if (grid[i][j] != 1) return 0;
        grid[i][j] = islandNum;
        int area = 1;
        if (i > 0) area += traverseIsland(grid, i-1, j, islandNum);
        if (i < grid.length-1) area += traverseIsland(grid, i+1, j, islandNum);
        if (j > 0) area += traverseIsland(grid, i, j-1, islandNum);
        if (j < grid[0].length-1) area += traverseIsland(grid, i, j+1, islandNum);
        return area;
    }
    
}