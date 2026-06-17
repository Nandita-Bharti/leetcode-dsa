class Solution {
    public int fib(int n) {    
    // Memoization -> TC & SC = 0(n+n)
    //     int[] dp = new int[n+1];
    //     return fibo(n,dp);
    // }
    // public int fibo(int n , int[] dp){
    //     if(n <= 1) return n;
    //     if(dp[n] != 0) return dp[n];
    //     int ans = fibo(n-1 , dp) + fibo(n-2 , dp);
    //     dp[n] = ans;    //at start dp[2] = 1;
    //     return ans;


    //Better approach -> Tabulation
    //Optimal - Using prev1 prev2
    if(n <= 1) return n;
    int prev1 = 0 , prev2 = 1;
    for(int i = 2; i <= n; i++){
        int curr = prev1 + prev2;
        prev1 = prev2;
        prev2 = curr;
    }
    return prev2;
    }
}