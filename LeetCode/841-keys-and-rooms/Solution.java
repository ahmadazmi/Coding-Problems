import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> keys = new Stack<>();
        for (Integer k : rooms.get(0)) keys.add(k);
        visited[0] = true;
        while (!keys.isEmpty()) {
            int key = keys.pop();
            for (Integer k : rooms.get(key))
                if (!visited[k]) keys.add(k);
            visited[key] = true;
        }
        for (boolean isVisited : visited) if (!isVisited) return false;
        return true;
    }
}