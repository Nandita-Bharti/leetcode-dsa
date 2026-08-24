class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    if(dfs(grid , i , j) % k == 0) count++;
                }
            }
        }
        return count;
    }
    long dfs(int[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        long currSum = grid[i][j];
        grid[i][j] = 0;

        long totalSum = currSum + dfs(grid , i+1 , j) + dfs(grid , i , j+1) + dfs(grid , i-1 , j) + dfs(grid , i , j-1);
        return totalSum;
    }
}