class Solution {    
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];        
        System.arraycopy(cuts, 0, newCuts, 1, c);
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);
        
        int m = newCuts.length;
        // We use size m x m because indices i and j can go up to m-1
        int[][] memo = new int[m][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, m - 1, newCuts, memo);
    }    
    int solve(int i, int j, int[] newCuts, int[][] memo) {
        if (j - i <= 1) return 0;
        if (memo[i][j] != -1) return memo[i][j];           
        int minCost = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = solve(i, k, newCuts, memo) + solve(k, j, newCuts, memo) + (newCuts[j] - newCuts[i]);
            if (cost < minCost) minCost = cost;
        }
        memo[i][j] = minCost;       
        return minCost;
    }
}

// class Solution {
//     public int minCost(int n, int[] cuts) {
//         int c = cuts.length;
//         int[] newCuts = new int[c+2];
//         System.arraycopy(cuts , 0 , newCuts , 1 , c);
//         newCuts[c+1] = n;
//         Arrays.sort(newCuts);
//         return solve(0 , newCuts.length - 1 , newCuts);
//     }
//     int solve(int i , int j, int[] newCuts){
//         if(j - i <= 1) return 0;
//         int minCost = Integer.MAX_VALUE;
//         // Try making a cut at every possible point 'k' between i and j
//         for (int k = i + 1; k < j; k++) {
//             int cost = solve(i, k , newCuts) + solve(k, j , newCuts) + (newCuts[j] - newCuts[i]);
//             if (cost < minCost) minCost = cost;
            
//         }

//         return minCost;
//     }
// }