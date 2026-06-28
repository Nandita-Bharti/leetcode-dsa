// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return f(n, m, text1, text2, dp);
//     }
//     int f(int idx1, int idx2, String text1, String text2, int[][] dp) {
//         if(idx1 == 0 || idx2 == 0) return 0;
//         if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
//         if(text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) {
//             return dp[idx1][idx2] = 1 + f(idx1 - 1, idx2 - 1, text1, text2, dp);
//         }
//         return dp[idx1][idx2] = Math.max(f(idx1 - 1, idx2, text1, text2, dp) , f(idx1, idx2 - 1, text1, text2, dp));
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() , n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int j = 0; j <= n; j++) dp[0][j] = 0;
        for(int i = 0; i <= m; i++) dp[i][0] = 0;
    
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}