class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long evenPosition = (n+1)/2;
        long oddPosition = n/2;

        long even = pow(5 , evenPosition , mod);
        long odd = pow(4 , oddPosition , mod);
        return (int)((even*odd) % mod);
    }
    long pow(long base , long expo , long mod){
        if(expo == 0) return 1;
        long half = pow(base, expo / 2 , mod);
        long halfSquared = (half * half) % mod;
        
        if (expo % 2 == 0) {
            return halfSquared;
        } else {
            return ((base % mod) * halfSquared) % mod;
        }
    }
}