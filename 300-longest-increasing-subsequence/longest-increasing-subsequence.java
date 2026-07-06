class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length , maxi = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 1 indicates a length of least subsequence which is the element itself
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[i] > nums[prev]){
                    dp[i] = Math.max(dp[i] , 1 + dp[prev]);
                    maxi = Math.max(maxi , dp[i]);
                }
            }
        }
    return maxi;
    }
}

//Space optimization
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int[] next=new int[n+1];

//         for(int index=n-1;index>=0;index--){
//             int[] curr=new int[n+1];
//             for(int prev=index-1;prev>=-1;prev--){
//                 int notTake=next[prev+1];
//                 int take=0;
//                 if(prev==-1 || nums[index]>nums[prev])
//                     take=1+next[index+1];

//                 curr[prev+1]=Math.max(take,notTake);
//             }
//             next=curr;
//         }
//         return next[0];
//     }
// }

//Tabulation 1

// class Solution {
//    public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int[][] dp=new int[n+1][n+1];

//         for(int index=n-1;index>=0;index--){

//             for(int prev=index-1;prev>=-1;prev--){

//                 int notTake=dp[index+1][prev+1];

//                 int take=0;

//                 if(prev==-1 || nums[index]>nums[prev])
//                     take=1+dp[index+1][index+1];

//                 dp[index][prev+1]=Math.max(take,notTake);
//             }
//         }

//         return dp[0][0];
//     }
// }


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int[][] dp=new int[n][n+1];
//         for(int[] row:dp)
//             Arrays.fill(row,-1);
//         return f(0,-1,nums,dp);
//     }
//     int f(int index,int prev,int[] nums,int[][] dp){
//         if(index==nums.length)
//             return 0;
//         if(dp[index][prev+1]!=-1)
//             return dp[index][prev+1];

//         int notTake=f(index+1,prev,nums,dp);
//         int take=0;

//         if(prev==-1 || nums[index]>nums[prev])
//             take=1+f(index+1,index,nums,dp);

//         return dp[index][prev+1]=Math.max(take,notTake);
//     }
// }