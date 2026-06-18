class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];        
        for (int i = 0; i < n; i++) {
            if (i != n - 1) arr1[i] = nums[i]; // Houses 0 to n-2
            if (i != 0) arr2[i - 1] = nums[i]; // Houses 1 to n-1
        }        
        return Math.max(tabulate(arr1), tabulate(arr2));
    }
    
    private int tabulate(int[] arr) {
        int m = arr.length;
        if (m == 0) return 0;
        if (m == 1) return arr[0];
        
        int[] dp = new int[m];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < m; i++) {
            int pick = arr[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[m - 1];
    }
}

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return nums[0];        
//         int[] dp1 = new int[n];
//         int[] dp2 = new int[n];
//         return Math.max(helper(nums, 0, n - 2, dp1), helper(nums, 1, n - 1, dp2));
//     }
    
//     private int helper(int[] nums, int start, int idx, int[] dp) {
//         if (idx < start) return 0;
//         if (idx == start) return nums[start];        
//         if (dp[idx] > 0) return dp[idx];        
//         int pick = nums[idx] + helper(nums, start, idx - 2, dp);
//         int notPick = helper(nums, start, idx - 1, dp);
        
//         return dp[idx] = Math.max(pick, notPick);
//     }
// }