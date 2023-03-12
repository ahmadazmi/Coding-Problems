import java.util.*;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) pq.offer(nums[i]);
        while (pq.size() < k) pq.offer(Integer.MIN_VALUE);
        while (pq.size() > k) pq.poll(); 
    }
    
    public int add(int val) {
        if (pq.peek() < val) {pq.offer(val); pq.poll();}
        return pq.peek();
    }
}