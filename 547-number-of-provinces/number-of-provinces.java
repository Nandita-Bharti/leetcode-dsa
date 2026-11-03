class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int c = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){            
            if(!vis[i]){
                dfs(i , adj , vis);
                c++;
            }
        }
        return c;
    }
    void dfs(int i , int[][] adj , boolean[] vis){
        vis[i] = true;
        for(int j = 0; j < adj[i].length; j++){
            if(adj[i][j] == 1 && !vis[j]){
                dfs(j , adj , vis);
            }
        }
    }
}