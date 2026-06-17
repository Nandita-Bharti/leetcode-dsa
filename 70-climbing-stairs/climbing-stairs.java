class Solution {
    public int climbStairs(int n) {
    //     Method 1 -> TC - 0(2^n) , SC - 0(n)
    //     return helper(0,n);
    // }
    // public int helper(int i, int n){
    //     if(i == n) return 1;
    //     if(i > n) return 0;
    //     int way1 = helper(i+1,n);
    //     int way2 = helper(i+2,n);
    //     return way1+way2;

    //Method 2 -> Memoizaton TC - 0() , SC - 0()
        int[] dp = new int[n+1];
        return fibo(0,n,dp);
    }
    public int fibo(int idx, int n , int[] dp){
        if(idx == n) return 1;
        if(idx > n) return 0;
        if(dp[idx] != 0) return dp[idx];
        int ans = fibo(idx+1 , n , dp) + fibo(idx+2 , n , dp);
        dp[idx] = ans;
        return ans;
    }
}