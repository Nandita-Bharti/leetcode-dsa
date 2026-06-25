class Solution {
    public int coinChange(int[] coins , int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        for(int j = 0; j <= amount; j++){
            if(j % coins[0] == 0) dp[0][j] = j / coins[0];
            else dp[0][j] = (int)1e9;
        }
            for(int i = 1; i < n; i++){
                for(int j = 0; j <= amount; j++){
                    int notTake = 0 + dp[i-1][j];
                    int take = Integer.MAX_VALUE;
                    if(coins[i] <= j) take = 1 + dp[i][j-coins[i]];
                    dp[i][j] = Math.min(notTake , take);
                }
            }
        // int ans = f(coins , n-1 , amount , dp);
        // return ans >= 1e9 ? -1 : ans;
        return dp[n-1][amount] >= 1e9 ? -1 : dp[n-1][amount];
    }
}
//     int f(int[] coins , int idx , int amount , int[][] dp){
//         if(idx == 0){
//             if(amount % coins[0] == 0) return amount/coins[0];
//             else return (int)1e9;
//         }
//         if(dp[idx][amount] != -1) return dp[idx][amount];
//         int notTake = 0 + f(coins , idx-1 , amount , dp);
//         int take = Integer.MAX_VALUE;
//         if(coins[idx] <= amount) take = 1 + f(coins , idx , amount-coins[idx] , dp);
        
//         int ans = Math.min(notTake , take);
//         return dp[idx][amount] = ans;
//     }
// }