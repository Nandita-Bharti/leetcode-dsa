class Solution {
    public int arrangeCoins(int n) {
        // Method 1. Using Built-in func
        // long m1 = (long) n;
        // long m2 = 8*m1+1;
        // return (int)(Math.sqrt(m2)-1)/2;

        //Method 2.
        long m = (long) n;
        return (mySqrt(8*m+1)-1)/2;

    }
    public int mySqrt(long x){
        long low = 1 ,high = x;
        if(x == 0) return 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid == x/mid) return (int)mid;
            else if(mid > x/mid) high = mid-1;
            else low = mid+1;
        }
        return (int)high;
    }
}