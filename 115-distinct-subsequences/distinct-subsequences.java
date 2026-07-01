class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();

        int[] dp = new int[m + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = m; j >= 1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }

        return dp[m];
    }
}
// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length(), m = t.length();
//         int[][] dp = new int[n][m];

//         for(int[] row : dp)
//             Arrays.fill(row, -1);

//         return f(n-1, m-1, s, t, dp);
//     }

//     int f(int i, int j, String s, String t, int[][] dp) {
//         if(j < 0) return 1;
//         if(i < 0) return 0;

//         if(dp[i][j] != -1)
//             return dp[i][j];

//         if(s.charAt(i) == t.charAt(j)) {
//             return dp[i][j] =
//                 f(i-1, j-1, s, t, dp) +
//                 f(i-1, j, s, t, dp);
//         }

//         return dp[i][j] = f(i-1, j, s, t, dp);
//     }
// }

// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length(), m = t.length();
//         int[][] dp = new int[n + 1][m + 1];

//         for(int i = 0; i <= n; i++)
//             dp[i][0] = 1;

//         for(int i = 1; i <= n; i++) {
//             for(int j = 1; j <= m; j++) {
//                 if(s.charAt(i-1) == t.charAt(j-1)) {
//                     dp[i][j] =
//                         dp[i-1][j-1] + dp[i-1][j];
//                 } else {
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }

// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length(), m = t.length();

//         int[] prev = new int[m + 1];
//         prev[0] = 1;

//         for(int i = 1; i <= n; i++) {
//             int[] curr = new int[m + 1];
//             curr[0] = 1;

//             for(int j = 1; j <= m; j++) {
//                 if(s.charAt(i-1) == t.charAt(j-1)) {
//                     curr[j] = prev[j-1] + prev[j];
//                 } else {
//                     curr[j] = prev[j];
//                 }
//             }

//             prev = curr;
//         }

//         return prev[m];
//     }
// }
