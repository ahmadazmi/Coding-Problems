import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> u = new HashSet<Integer>();
        HashSet<Integer> v = new HashSet<Integer>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i]) continue;
            if (!setOne(graph, u, v, i, visited)) return false;
        }
        return true;
    }
    
    private boolean setOne(int[][] graph, HashSet<Integer> u, HashSet<Integer> v, int i, boolean[] visited) {
        if (v.contains(i)) return false;
        if (visited[i]) return true;
        u.add(i);
        visited[i] = true;
        for (int edge : graph[i])
            if (!setTwo(graph, u, v, edge, visited)) return false;
        return true;
    }
    
    private boolean setTwo(int[][] graph, HashSet<Integer> u, HashSet<Integer> v, int i, boolean[] visited) {
        if (u.contains(i)) return false;
        if (visited[i]) return true;
        v.add(i);
        visited[i] = true;
        for (int edge : graph[i])
            if (!setOne(graph, u, v, edge, visited)) return false;
        return true;
    }
}