class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Idea: Create min and max capacities
        // Initially, min = the max weight in weights and max = sum of all weights
        // Check how many days (crntDays) would (min+max)/2 capacity would take.
        // If crntDays == days then we return the capacity
        // If crntDays > days then max = (min+max)/2
        // else min = (min+max)/2
        int min = 0, max = 0;
        for (int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        if (days == 1) return max;
        int crntDays = 0;
        while (min < max) {
            int mid = (min+max)/2;
            crntDays = daysTakenToShip(weights, mid);
            if (crntDays <= days) max = mid;
            else min = mid+1;
        }
        return min;
    }
    
    private int daysTakenToShip(int[] weights, int capacity) {
        int days = 1;
        int crntCapacity = 0;
        for (int weight : weights) {
            if (crntCapacity + weight > capacity) {days++; crntCapacity = 0;}
            crntCapacity += weight;
        }
        return days;
    }
}