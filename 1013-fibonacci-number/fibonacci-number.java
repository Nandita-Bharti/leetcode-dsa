class Solution {
    public int fib(int n) {    //TC & SC = 0(n+n)
        int[] dp = new int[n+1];
        return fibo(n,dp);
    }
    public int fibo(int n , int[] dp){
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        int ans = fibo(n-1 , dp) + fibo(n-2 , dp);
        dp[n] = ans;    //at start dp[2] = 1;
        return ans;
    }
}