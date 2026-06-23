// class Solution {
//     public boolean canPartition(int[] nums) {
//         int totalSum = 0;
//         int n = nums.length;
//         for(int i = 0; i<n;i++){
//             totalSum += nums[i];
//         }
//         if(totalSum % 2 != 0) return false;
//         int[][] dp = new int[n][totalSum/2 + 1];
//         return f(nums , totalSum/2 , n-1 , dp);
//     }
//     public boolean f(int[] nums , int target , int idx , int[][] dp){
//         if(target  == 0) return true;
//         if(idx == 0) return nums[0] == target;
//         if(dp[idx][target] != 0) return dp[idx][target] == 1;
//         boolean notTake = f(nums , target , idx-1 , dp);
//         boolean take = false;
//         if(target >= nums[idx]) take = f(nums , target-nums[idx] , idx-1 , dp);
//         boolean ans = take || notTake;
//         dp[idx][target] = ans ? 1 : 0;
//         return ans;
        
//     }
// }
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int num : nums) {
            totalSum += num;
        }
        if(totalSum % 2 != 0) return false;
        boolean[][] dp = new boolean[n][totalSum/2 + 1];
        return f(nums , totalSum/2 , n , dp);

    }
    public boolean f(int[] nums , int target , int n , boolean[][] dp){
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target) dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j >= nums[i]) take = dp[i-1][j-nums[i]];
                boolean ans = take || notTake;
                dp[i][j] = ans;
            }
        }
        return dp[n-1][target];
    }
}