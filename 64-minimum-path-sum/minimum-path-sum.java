// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         for(int j = 1; j < n; j++) grid[0][j] += grid[0][j-1];
//         for(int i = 1; i < m; i++) grid[i][0] += grid[i-1][0];

//         for(int i = 1; i < m; i++){
//             for(int j = 1; j < n; j++){
//                 grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
//             }
//         }
//         return grid[m-1][n-1];
//     }
// }
import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }        
        return f(grid, m - 1, n - 1, dp);
    }
    
    public int f(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        // Out of bounds: Return a large number that won't overflow when added to
        if (i < 0 || j < 0) return 100000000; 
        if (dp[i][j] != -1) return dp[i][j];
        
        int up = grid[i][j] + f(grid, i - 1, j, dp);
        int left = grid[i][j] + f(grid, i, j - 1, dp);
        
        return dp[i][j] = Math.min(up, left);
    }
}