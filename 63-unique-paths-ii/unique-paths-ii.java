class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1) return 0;

        // First row
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1) {
                grid[0][j] = 0;
            } else if(j == 0) {
                grid[0][j] = 1;
            } else {
                grid[0][j] = grid[0][j-1];
            }
        }

        // First column
        for(int i = 1; i < m; i++){
            if(grid[i][0] == 1) {
                grid[i][0] = 0;
            } else {
                grid[i][0] = grid[i-1][0];
            }
        }

        // Fill rest
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        return grid[m-1][n-1];
    }
}