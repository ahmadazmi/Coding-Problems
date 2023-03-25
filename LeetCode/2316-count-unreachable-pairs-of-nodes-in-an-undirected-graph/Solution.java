import java.util.*;

class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        long pairs = 0, current = 0, total = 0;
        createGraph(graph, edges, n);
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            current = dfs(graph, visited, i);
            pairs += total * current;
            total += current;
        }
        return pairs;
    }

    private void createGraph(List<List<Integer>> graph, int[][] edges, int n) {
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        if (visited[node]) return 0;
        int nodes = 0;
        visited[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) nodes += dfs(graph, visited, graph.get(node).get(i));
        return nodes + 1;
    }
}