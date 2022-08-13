import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        boolean onlyZeros = true;
        String[] numsStr = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) onlyZeros = false;
            numsStr[i] = nums[i]+"";
        }
        if (onlyZeros) return "0";
        
        Arrays.sort(numsStr, (a, b) -> (b+a).compareTo(a+b));
        
        StringBuilder largestNumber = new StringBuilder();
        for (String num : numsStr)
            largestNumber.append(num);
        return largestNumber.toString();
    }
}