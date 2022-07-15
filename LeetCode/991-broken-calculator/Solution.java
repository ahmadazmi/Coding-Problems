class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;
        int crnt = target;
        target = startValue;
        while (crnt > target) {
            if ((crnt & 1) == 0) crnt /= 2;
            else crnt++;
            operations++;
        }
        return operations+(target-crnt);
    }
}