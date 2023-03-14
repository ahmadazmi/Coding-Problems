import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for (int i = 0; i < stones.length; i++) pq.offer(stones[i]);
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 == s2) continue;
            pq.offer(s1-s2);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}