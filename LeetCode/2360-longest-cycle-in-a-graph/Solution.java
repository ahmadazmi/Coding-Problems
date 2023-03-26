class Solution {
    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) continue;
            max = Math.max(max, findCycle(edges, visited, i));
            visited[i] = true;
        }
        return max;
    }

    private int findCycle(int[] edges, boolean[] visited, int start) {
        int cycle = 0, i = start, j = start;
        do {
            if (visited[i] || edges[j] == -1 || edges[edges[j]] == -1) return -1;
            i = edges[i];
            j = edges[edges[j]];
        } while (i != j);
        do {visited[i] = true; i = edges[i]; cycle++;} while (i != j);
        return cycle;
    }
}