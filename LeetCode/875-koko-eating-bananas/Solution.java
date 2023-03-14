class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1, mid;
        for (int i = 0; i < piles.length; i++) if (piles[i] > right) right = piles[i];
        while (left < right) {
            mid = (right+left)/2;
            if (validEatingSpeed(piles, mid, h)) right = mid;
            else left = mid+1;
        }
        return right;
    }

    private boolean validEatingSpeed(int[] piles, int k, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length && hours <= h; i++) hours += Math.ceil((double)piles[i]/k);
        return hours <= h;
    }
}