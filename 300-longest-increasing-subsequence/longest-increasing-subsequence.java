class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return f(0,-1,nums,dp);
    }
    int f(int index,int prev,int[] nums,int[][] dp){
        if(index==nums.length)
            return 0;
        if(dp[index][prev+1]!=-1)
            return dp[index][prev+1];
        int notTake=f(index+1,prev,nums,dp);
        int take=0;
        if(prev==-1 || nums[index]>nums[prev])
            take=1+f(index+1,index,nums,dp);
        return dp[index][prev+1]=Math.max(take,notTake);
    }
}