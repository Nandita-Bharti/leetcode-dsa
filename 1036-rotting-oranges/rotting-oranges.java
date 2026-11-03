class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j =  0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int i = current[0] , j = current[1] , t = current[2];
            ans = Math.max(t , ans);
            if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1){
                q.offer(new int[]{i-1 , j , t+1});
                visited[i-1][j] = true;
            }
            if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 1){
                q.offer(new int[]{i , j-1 , t+1});
                visited[i][j-1] = true;
            }
            if(i+1 < m && !visited[i+1][j] && grid[i+1][j] == 1){
                q.offer(new int[]{i+1 , j , t+1});
                visited[i+1][j] = true;
            }if(j+1 < n && !visited[i][j+1] && grid[i][j+1] == 1){
                q.offer(new int[]{i , j+1 , t+1});
                visited[i][j+1] = true;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]) return -1;
            }
        }
        return ans;
    }
}