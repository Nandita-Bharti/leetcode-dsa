class Solution {
    public boolean isPowerOfTwo(int n) {
    //      Method 1
    //     if(n == 1) return true;
    //     if(n < 1) return false;
    //     if( n%2 == 1) return false;
    //     return isPowerOfTwo(n/2);
        return n > 0 && ((n & (n-1)) == 0);
    }
}