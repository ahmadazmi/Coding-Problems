import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        // Idea: think of this as a graph where each orange is connected
        // to the adjacent oranges (i.e. 4 edges if 4 oranges adjacent to our orange). 
        // Start by finding all rotten oranges.
        // Add all rotten oranges in a Queue and BFS from there.
        // If any rotten orange has an adjacent good orange, turn it into a rotten orange and
        // add it to the Queue.  
        // The Queue will be empty if and only if all oranges are now rotten, or if some orange
        // cannot be reached by the rotten orange.
        // The grid will have to be looped again to check if any non-rotten oranges are left.
        // Time Complexity: O(m*n), Space Complexity: O(m*n)
        
        // Queue will contain a 2D array of size 2 to hold the X,Y position of the orange in the grid
        LinkedList<Integer[]> bfs = new LinkedList<Integer[]>();
        // Loop over the grid and find all rotten oranges
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 2) bfs.add(new Integer[]{i,j});
        
        // BFS over the grid and keep track of time
        int time = -1;
        while(!bfs.isEmpty()) {
            int numRotten = bfs.size();
            for (int i = 0; i < numRotten; i++) {
                Integer[] pos = bfs.remove();
                if (pos[0]+1 < grid.length && grid[pos[0]+1][pos[1]] == 1) {
                    bfs.add(new Integer[]{pos[0]+1, pos[1]});
                    grid[pos[0]+1][pos[1]] = 2;
                }
                if (pos[0]-1 >= 0 && grid[pos[0]-1][pos[1]] == 1) {
                    bfs.add(new Integer[]{pos[0]-1, pos[1]});
                    grid[pos[0]-1][pos[1]] = 2;
                }
                if (pos[1]+1 < grid[0].length && grid[pos[0]][pos[1]+1] == 1) {
                    bfs.add(new Integer[]{pos[0], pos[1]+1});
                    grid[pos[0]][pos[1]+1] = 2;
                }
                if (pos[1]-1 >= 0 && grid[pos[0]][pos[1]-1] == 1) {
                    bfs.add(new Integer[]{pos[0], pos[1]-1});
                    grid[pos[0]][pos[1]-1] = 2;
                }
            }
            time++;
        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) return -1;
        return time < 0 ? 0 : time;
    }
}