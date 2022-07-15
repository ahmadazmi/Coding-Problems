import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a directed graph of prerequisites using HashMap
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            if (!graph.containsKey(prereq[0]))
                graph.put(prereq[0], new ArrayList<>());
            graph.get(prereq[0]).add(prereq[1]);
        }
        // Idea: Traverse the graph and create a topologically sorted graph
        // If this sorted graph has any nodes pointing backwards to another node
        // then the course schedule prerequisites are impossible to fulfill
        LinkedList<Integer> topSorted = new LinkedList<Integer>();
        boolean[] visited = new boolean[numCourses];
        for (int course : graph.keySet()) {
            if (visited[course]) continue;
            dfs(course, graph, visited, topSorted);
        }
        visited = new boolean[numCourses];
        for (int course : topSorted) {
            visited[course] = true;
            for (int neighbor : graph.get(course))
                if (visited[neighbor]) return false;
        }
        return true;
    }
    
    private void dfs(int course, HashMap<Integer, List<Integer>> graph, boolean[] visited, LinkedList<Integer> topSort) {
        visited[course] = true;
        if (!graph.containsKey(course)) return;
        for (int neighbor : graph.get(course)) {
            if (visited[neighbor]) continue;
            dfs(neighbor, graph, visited, topSort);
        }
        topSort.addFirst(course);
    }
}