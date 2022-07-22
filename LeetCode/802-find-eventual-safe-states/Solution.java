import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<Integer>();
        Boolean[] isSafe = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (traverseNodes(graph, isSafe, i))
                safeNodes.add(i);
        return safeNodes;
    }
    
    private boolean traverseNodes(int[][] graph, Boolean[] isSafe, int i) {
        if (isSafe[i] != null) return isSafe[i];
        isSafe[i] = false;
        for (int neighbor : graph[i])
            if (!traverseNodes(graph, isSafe, neighbor))
                return false;
        isSafe[i] = true;
        return true;
    }
    
}