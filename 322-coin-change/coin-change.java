class Solution {
    public int coinChange(int[] coins , int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int ans = f(coins , n-1 , amount , dp);
        return ans >= 1e9 ? -1 : ans;

    }
    int f(int[] coins , int idx , int amount , int[][] dp){
        if(idx == 0){
            if(amount % coins[0] == 0) return amount/coins[0];
            else return (int)1e9;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notTake = 0 + f(coins , idx-1 , amount , dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) take = 1 + f(coins , idx , amount-coins[idx] , dp);
        
        int ans = Math.min(notTake , take);
        return dp[idx][amount] = ans;
    }
}