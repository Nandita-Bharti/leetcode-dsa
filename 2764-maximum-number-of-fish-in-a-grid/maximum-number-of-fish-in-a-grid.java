class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    maxFish = Math.max(maxFish , dfs(grid , i , j));

                }
            }
        }
        return maxFish;
    }
    int dfs(int[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        int currFish = grid[i][j];
        grid[i][j] = 0;
        int totalFish = currFish + dfs(grid , i+1 , j) + dfs(grid , i , j+1) + dfs(grid , i-1 , j) + dfs(grid , i , j-1);

        return totalFish;
    }
}