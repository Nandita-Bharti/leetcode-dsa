class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); 
        int[][] dp = new int[n][n];
    //     return f(triangle , 0 , 0 , n , dp);
    // }
    // int f(List<List<Integer>> triangle , int i , int j , int n , int[][] dp){
    //     if(i == n-1) return triangle.get(n-1).get(j);
    //     if(dp[i][j] != 0) return dp[i][j];
    //     int down = triangle.get(i).get(j) + f(triangle , i+1 , j , n , dp);
    //     int diagonal = triangle.get(i).get(j) + f(triangle , i+1 , j+1 , n , dp);
    //     return dp[i][j] = Math.min(down , diagonal);
    // }

    //Tabulation
    // Base Case: Initialize the bottom row of DP table with the triangle's bottom row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}
