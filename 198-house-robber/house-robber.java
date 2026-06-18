class Solution {
    public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     return helper(nums,0,dp);
    // }
    // public int helper(int[] nums, int i, int[] dp){
    //     if(i >= nums.length) return 0;
    //     if(dp[i] > 0) return dp[i];
    //     int pick = nums[i] + helper(nums,i+2,dp);
    //     int skip = helper(nums,i+1,dp);
    //     int ans = Math.max(pick,skip);
    //     dp[i] = ans;
    //     return ans;

    int n = nums.length;
        
        // Edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // dp[i] stores the max money money till house i
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }
}