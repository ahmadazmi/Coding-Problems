import java.util.*;

class Solution {
	@SuppressWarnings("unchecked")
    public int makeConnected(int n, int[][] connections) {
        /*
         * Solution concept:
         * Create a relation graph.
         * Also, create integer disconnected_count and extra_count.
         * Pick computer 0, DFS from there.
         * Find number of extra cables in that DFS (num_edges - num_nodes - 1), store in extra_count.
         * Pick computer X, where X is a computer that was not visited through computer 0's DFS.
         * Find number of extra cables in X's DFS, update extra_count.
         * Increment disconnected_count as X is disconnected from computer 0.
         * Repeat until all computers have been visited.
         * Return: extra_count >= disconnected_count ? disconnected_count : -1
         */
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        boolean[] visited = new boolean[n];
        int groups = -1, extras = 0, i = 0, j = 0;
        createGraph(graph, connections, n);
        while (i < n) {
            j = i;
            dfs(graph, visited, i);
            while (i < n && visited[i]) i++;
            int edges = 0;
            for (int k = j; k < i; k++) edges += graph[k].size();
            extras += ((edges>>1) - (i-j-1));
            groups++;
        }
        return extras >= groups ? groups : -1;
    }

    private void createGraph(ArrayList<Integer>[] graph, int[][] connections, int n) {
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < connections.length; i++) {
            graph[connections[i][0]].add(connections[i][1]);
            graph[connections[i][1]].add(connections[i][0]);
        }
    }

    private void dfs(ArrayList<Integer>[] graph, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < graph[i].size(); j++) dfs(graph, visited, graph[i].get(j));
    }
}