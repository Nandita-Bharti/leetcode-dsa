class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        int opt1 =  f(n-1 , cost , dp);
        int opt2 = f(n-2 , cost , dp);
        return Math.min(opt1 , opt2);
    }
    int f(int i , int[] cost , int[] dp){
        if(i == 0) return cost[0];
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        int cost1 = cost[i] + f(i-1, cost , dp);
        int cost2 = cost[i]+f(i-2,cost , dp);
        return dp[i] = Math.min(cost1 , cost2);
    }
}