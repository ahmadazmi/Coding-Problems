import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        // Intuition: The minimum steps required to reach the last index means that each index visited
        // in our optimal path is also reached in least steps as possible.
        // If we treat our array as a graph, where each node is visited at most once, we can deploy
        // Breadth First Search which will let us find the quickest way to the last index.
        HashMap<Integer, LinkedList<Integer>> intToIdx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!intToIdx.containsKey(arr[i])) intToIdx.put(arr[i], new LinkedList<>());
            intToIdx.get(arr[i]).add(i);
        }
        LinkedList<Integer> bfs = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        int steps = 0;
        bfs.addFirst(0);
        visited[0] = true;
        while (!bfs.isEmpty()) {
            int len = bfs.size();
            for (int i = 0; i < len; i++) {
                int index = bfs.removeLast();
                if (index == arr.length-1) return steps;
                LinkedList<Integer> jumps = intToIdx.get(arr[index]);
                while (!jumps.isEmpty()) {
                    if (!visited[jumps.getFirst()]) bfs.addFirst(jumps.getFirst());
                    visited[jumps.removeFirst()] = true;
                }
                if (index > 0 && !visited[index-1]) {bfs.addFirst(index-1); visited[index-1] = true;}
                if (index < arr.length-1 && !visited[index+1]) {bfs.addFirst(index+1); visited[index+1] = true;};
            }
            steps++;
        }
        return steps;
    }
}