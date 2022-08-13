import java.util.Arrays;

class Solution {
    
    int mod = 1000000000 + 7;
    
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        // HashMap<Integer, Long> dp = new HashMap<Integer, Long>();
        long[] dp = new long[arr.length];
        long ways = 0;
        for (int i = 0; i < arr.length; i++) {
            ways = (ways + numFactoredBinaryTreesUsingX(arr, i, dp))%mod;
        }
        // for (int num : arr) System.out.print(num+": "+dp.get(num)+", ");
        // System.out.println();
        return (int)(ways%mod);
    }
    
    private long numFactoredBinaryTreesUsingX(int[] arr, int i, long[] dp) {
        long ways = 1;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if ((long)arr[i] == (long)arr[j] * (long)arr[k]) {
                    // System.out.println(arr[i]+" = "+arr[j]+" ("+dp.get(arr[j])+") * "+arr[k]+" ("+dp.get(arr[k])+")");
                    ways = (ways + (dp[j] * dp[k])%mod)%mod;
                }
                else if ((long)arr[i] < (long)arr[j] * (long)arr[k]) break;
            }
        }
        dp[i] = ways%mod;
        return dp[i];
    }
    
}