class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                if(j == 1){
                    int doBuy = -prices[i] + dp[i+1][0];
                    int notBuy = 0 + dp[i+1][1];
                    dp[i][j] = Math.max(doBuy , notBuy);
                }
                else{
                    int doSell = prices[i] + dp[i+1][1];
                    int notSell = 0 + dp[i+1][0];
                    dp[i][j] = Math.max(doSell , notSell);
                }
            }
        }
        return dp[0][1];
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int buy = 1 , n = prices.length , i = 0;
//         int[][] dp = new int[n][2];
//         for(int[] row: dp){
//             Arrays.fill(row , -1);
//         }
//         return f(prices , i , buy , n , dp);
//     }
//     int f(int[] prices , int i , int buy , int n , int[][] dp){
//         int profit = 0;
//         if(i == n) return 0;
//         if(dp[i][buy] != -1) return dp[i][buy];
//         if(buy == 1){
//             int doBuy = -prices[i] + f(prices , i+1 , 0 , n , dp);
//             int notBuy = 0 + f(prices , i+1 , 1 , n , dp);
//             dp[i][buy] = Math.max(doBuy , notBuy);
//         }
//         else{
//             int doSell = prices[i] + f(prices , i+1 , 1 , n , dp);
//             int notSell = 0 + f(prices , i+1 , 0 , n , dp);
//             dp[i][buy] = Math.max(doSell , notSell);
//         }
//         return dp[i][buy];
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices) {
        
//     }
// }