class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n+2];
        nums2[0] = 1;
        System.arraycopy(nums, 0, nums2, 1, n);
        nums2[n+1] = 1;
        
        int[][] memo = new int[n+2][n+2];
        for(int i = 0; i < n+2; i++) {
            for(int j = 0; j < n+2; j++) {
                memo[i][j] = -1;
            }
        }
        
        return f(1, n, nums2, memo);
    }
    
    int f(int i, int j, int[] nums2, int[][] memo){
        if(i > j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        
        int maxCoins = Integer.MIN_VALUE;
        
        for(int k = i; k <= j; k++){
            int leftSubproblem = f(i, k - 1, nums2, memo);
            int rightSubproblem = f(k + 1, j, nums2, memo);
            int coinsToBurstK = nums2[i - 1] * nums2[k] * nums2[j + 1];
            
            int totalCoins = leftSubproblem + rightSubproblem + coinsToBurstK;
            maxCoins = Math.max(maxCoins, totalCoins);
        }
        
        return memo[i][j] = maxCoins;
    }
}


//Recursion
// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] nums2 = new int[n+2];
//         nums2[0] = 1;
//         System.arraycopy(nums , 0 , nums2 , 1 , n);
//         nums2[n+1] = 1;
//         return f(1 , n , nums2);
//     }
//     int f(int i , int j , int[] nums2){
//         if(i > j) return 0;
//         int maxCoins = Integer.MIN_VALUE;
//         for(int k = i; k <= j; k++){
//             int coins = nums2[i-1]*nums2[k]*nums2[j+1] + f(i  , k-1 ,nums2) + f(k+1 , j , nums2);
//             maxCoins = Math.max(maxCoins , coins);
//         }
//         return maxCoins;
//     }
// }