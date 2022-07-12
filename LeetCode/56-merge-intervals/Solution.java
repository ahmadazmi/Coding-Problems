import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ranges = new ArrayList<int[]>();
        int[] lastInterval = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 0; i < intervals.length; i++) {
            if (lastInterval[1] >= intervals[i][0]) lastInterval[1] = Math.max(intervals[i][1], lastInterval[1]);
            else {
                ranges.add(lastInterval);
                lastInterval = new int[]{intervals[i][0], intervals[i][1]};
            }
        }
        ranges.add(lastInterval);
        return ranges.toArray(new int[ranges.size()][]);
    }
}