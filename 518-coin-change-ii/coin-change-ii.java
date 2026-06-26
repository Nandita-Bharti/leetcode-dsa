// Space Optimization
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for(int t = 0; t <= amount; t++) {
            if(t % coins[0] == 0)
                prev[t] = 1;
        }

        for(int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];

            for(int t = 0; t <= amount; t++) {
                int notTake = prev[t];

                int take = 0;
                if(coins[i] <= t)
                    take = curr[t - coins[i]];

                curr[t] = notTake + take;
            }

            prev = curr;
        }

        return prev[amount];
    }
}

//Memoization
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         for(int[] row : dp)
//             Arrays.fill(row, -1);

//         return f(coins, n - 1, amount, dp);
//     }

//     int f(int[] coins, int idx, int amount, int[][] dp) {
//         if(idx == 0) {
//             if(amount % coins[0] == 0) return 1;
//             return 0;
//         }

//         if(dp[idx][amount] != -1)
//             return dp[idx][amount];

//         int notTake = f(coins, idx - 1, amount, dp);

//         int take = 0;
//         if(coins[idx] <= amount)
//             take = f(coins, idx, amount - coins[idx], dp);

//         return dp[idx][amount] = notTake + take;
//     }
// }

// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         for(int t = 0; t <= amount; t++) {
//             if(t % coins[0] == 0)
//                 dp[0][t] = 1;
//         }

//         for(int i = 1; i < n; i++) {
//             for(int t = 0; t <= amount; t++) {
//                 int notTake = dp[i-1][t];

//                 int take = 0;
//                 if(coins[i] <= t)
//                     take = dp[i][t - coins[i]];

//                 dp[i][t] = notTake + take;
//             }
//         }

//         return dp[n-1][amount];
//     }
// }