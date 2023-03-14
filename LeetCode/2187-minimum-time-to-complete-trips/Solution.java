class Solution {
    public long minimumTime(int[] time, long totalTrips) {
        if (time.length == 1) return totalTrips*time[0];
        long minBusTime = Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) if (time[i] < minBusTime) minBusTime = time[i];
        long left = minBusTime, right = minBusTime*totalTrips, mid = (left+right)/2;
        while (left < right) {
            mid = (left+right)/2;
            if (trips(time, mid) < totalTrips) left = mid+1;
            else right = mid;
        }
        return right;
    }

    private long trips(int[] time, long givenTime) {
        long tripsMade = 0;
        for (int i = 0; i < time.length; i++) tripsMade += givenTime/time[i];
        return tripsMade;
    }
}