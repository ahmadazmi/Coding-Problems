import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> compareDist(p1, p2));
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        int[][] kClosestPoints = new int[k][2];

        for (int i = 0; i < k; i++) { //Also make sure there is enougth items in the queue.
          kClosestPoints[i] = pq.poll();
        }
        return kClosestPoints;
    }
    
      private static int compareDist(int[] p1, int[] p2) {
        double dist1 = p1[0]*p1[0] + p1[1]*p1[1];
        double dist2 = p2[0]*p2[0] + p2[1]*p2[1];
        if (dist1 == dist2) return 0;
        else if (dist1 > dist2) return 1;
        else return -1;
    }
}