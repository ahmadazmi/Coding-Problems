class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int frst = 0, scnd = cost[0], crnt = 0;
        for (int i = 1; i < cost.length; i++) {
            crnt = cost[i]+Math.min(frst, scnd);
            frst = scnd;
            scnd = crnt;
        }
        return Math.min(frst, scnd);
    }
}