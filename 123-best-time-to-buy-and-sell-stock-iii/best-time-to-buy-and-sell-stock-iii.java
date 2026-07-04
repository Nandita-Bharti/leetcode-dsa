class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];

        for(int i = n-1; i >= 0; i--){
            for(int j = 3; j >= 0; j--){
                if(j % 2 == 0){
                    int buy = -prices[i] + dp[i+1][j+1];
                    int notBuy = 0 + dp[i+1][j];
                    dp[i][j] = Math.max(buy , notBuy);
                }
                else{
                    int sell = prices[i] + dp[i+1][j+1];
                    int notSell = 0 + dp[i+1][j];
                    dp[i][j] = Math.max(sell , notSell);
                }
            }
        }
        return dp[0][0];
    }
}


// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length , trans = 0 , i = 0;
//         int[][] dp = new int[n][4];
//         for(int[] row : dp){
//             Arrays.fill(row , -1);
//         }
//        return f(i , trans , prices , dp); 
//     }
//     int f(int i , int trans , int[] prices , int[][] dp){
//         if(i == prices.length || trans == 4) return 0;
//         if(dp[i][trans] != -1) return dp[i][trans];
//         if(trans % 2 == 0){
//             int buy = -prices[i] + f(i+1 , trans+1 , prices , dp);
//             int notBuy = 0 + f(i+1 , trans , prices , dp);
//             return dp[i][trans] = Math.max(buy , notBuy);
//         }        
//             int sell = prices[i] + f(i+1 , trans+1 , prices , dp);
//             int notSell = 0 + f(i+1 , trans , prices , dp);
//             return dp[i][trans] = Math.max(sell , notSell);   
//     }
// }


// class Solution {
//     public int maxProfit(int[] prices) {
        
//     }
// }

