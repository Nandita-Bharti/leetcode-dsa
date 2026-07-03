class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m + 1];
        for(int j = 0; j <= m; j++)
            prev[j] = j;
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                } else {
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
// Tabulation
// class Solution {
//     public int minDistance(String s1, String s2) {
//         int m = s1.length() , n = s2.length();        
//         int[][] dp = new int[m+1][n+1];
//         for(int i = 0; i <= n; i++) dp[0][i] = i;
//         for(int j = 0; j <= m; j++) dp[j][0] = j;

//         for(int i = 1; i <= m; i++){
//             for(int j = 1; j <= n; j++){
//                 if(s1.charAt(i-1) == s2.charAt(j-1))  dp[i][j] =  0 + dp[i-1][j-1];
//                 else dp[i][j] =  1 + Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1] , dp[i][j-1]));
//             }
//         }
//         return dp[m][n];
//     }
// } 

// class Solution {
//     public int minDistance(String s1, String s2) {
//         int i = s1.length() - 1;
//         int j = s2.length() - 1;
//         return f(i , j , s1, s2);
//     }
//     int f(int i , int j , String s1 , String s2){
//         if(i < 0) return j+1;
//         if(j < 0) return i+1;
//         if(s1.charAt(i) == s2.charAt(j)){
//             return 0 + f(i-1 , j-1 , s1 , s2);
//         }
//         return 1 + Math.min(f(i-1 , j , s1 , s2) , Math.min(f(i-1 , j-1 , s1 , s2) , f(i , j-1 , s1 , s2)));
//     }
// }


//Memoization
// class Solution {
//     public int minDistance(String s1, String s2) {
//         int m = s1.length() , n = s2.length();
//         int i = m;
//         int j = n;
//         int[][] dp = new int[m+1][n+1];
//         return f(i , j , s1 , s2 , dp);
//     }
//     int f(int i , int j , String s1 , String s2 , int[][] dp){
//         if(i == 0) return j;
//         if(j == 0) return i;
//         if(dp[i][j] != 0) return dp[i][j];
//         if(s1.charAt(i-1) == s2.charAt(j-1)){
//             return dp[i][j] =  0 + f(i-1 , j-1 , s1 , s2 , dp);
//         }
//         return dp[i][j] =  1 + Math.min(f(i-1 , j , s1 , s2 , dp) , Math.min(f(i-1 , j-1 , s1 , s2, dp) , f(i , j-1 , s1 , s2,dp)));
//     }
// }