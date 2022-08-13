class Solution {
    public boolean validPartition(int[] nums) {
        // You are at X3:
        //  -> [...,F,X1,X2,X3]
        //      -> [...,F,F,X2,X3]
        //          -> [...,F,F,F,X3] -> No possible way to partition, return false.
        //          -> [...,F,F,T,X3] -> X3 is false
        //      -> [...,F,T,X2,X3] -> Check if num(X3) == num(X2)
        //  -> [...,T,X1,X2,X3]
        //      -> [...,T,F,X2,X3]
        //          -> [...T,F,F,X3] -> Check if num(X1)+2 == num(X2)+1 == num(X3)
        //          -> [...T,F,T,X3] -> Check if num(X1) == num(X2) == num(X3) OR num(X1)+2 == num(X2)+1 == num(X3)
        //      -> [...,T,T,X2,X3] -> Check if num(X2) == num(X3) OR num(X1)+2 == num(X2)+1 == num(X3)
        boolean one = false;
        boolean two = nums[0] == nums[1];
        if (nums.length <= 2) return two;
        boolean three = (two && nums[2] == nums[1]) || (nums[0]+1 == nums[1] && nums[1]+1 == nums[2]);
        if (nums.length <= 3) return three;
        boolean four = false;
        
        for (int i = 3; i < nums.length; i++) {
            if (one) {
                if (two) four = (nums[i-1] == nums[i]) || (nums[i-2]+1 == nums[i-1] && nums[i-1]+1 == nums[i]);
                else {
                    if (three) four = (nums[i-2] == nums[i-1] && nums[i-1] == nums[i]) || (nums[i-2]+1 == nums[i-1] && nums[i-1]+1 == nums[i]);
                    else four = (nums[i-2]+1 == nums[i-1] && nums[i-1]+1 == nums[i]);
                }
            }
            else {
                if (two) four = (nums[i-1] == nums[i]);
                else {
                    if (three) four = false;
                    else return false;
                }
            }
            one = two; two = three; three = four;
        }
        
        return four;
    }
}