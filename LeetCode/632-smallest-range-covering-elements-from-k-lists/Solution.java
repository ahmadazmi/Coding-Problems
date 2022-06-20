import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ptrs = new int[nums.size()]; // k pointers for k lists
        int[] range = {Integer.MIN_VALUE/2, Integer.MAX_VALUE/2}; // starting range (largest possible)
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]); // min heap containing K elements at a time
        int currentMax = Integer.MIN_VALUE; // stores the current max of the range
        int lastPtrChanged = 0;
        // fill min heap and find first max
        for (int i = 0; i < ptrs.length; i++) {
            minHeap.add(new Integer[]{nums.get(i).get(ptrs[i]), i});
            if (currentMax < nums.get(i).get(ptrs[i])) currentMax = nums.get(i).get(ptrs[i]);
        }
        while (ptrs[lastPtrChanged] < nums.get(lastPtrChanged).size()) {
            // compare current best range with new range
            Integer[] heapRoot = minHeap.poll();
            if (currentMax - heapRoot[0] < range[1] - range[0]) {
                range[0] = heapRoot[0]; range[1] = currentMax;
            }
            lastPtrChanged = heapRoot[1];
            ptrs[lastPtrChanged]++;
            if (ptrs[lastPtrChanged] < nums.get(lastPtrChanged).size()) {
                if (currentMax < nums.get(lastPtrChanged).get(ptrs[lastPtrChanged])) currentMax = nums.get(lastPtrChanged).get(ptrs[lastPtrChanged]);
                minHeap.add(new Integer[]{nums.get(lastPtrChanged).get(ptrs[lastPtrChanged]), lastPtrChanged});
            }
        }
        return range;
    }
    
}