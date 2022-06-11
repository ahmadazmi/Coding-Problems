import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> rowNonCrossings = new HashMap<Integer, Integer>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int j = 0; j < row.size()-1; j++) {
                sum += row.get(j);
                rowNonCrossings.merge(sum, 1, (a,b)-> a+b);
            }
        }
        
        if (rowNonCrossings.isEmpty()) return wall.size();
        int mostNonCrossings = Collections.max(rowNonCrossings.values());
        return wall.size() - mostNonCrossings;
    }
}