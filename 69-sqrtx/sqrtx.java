class Solution {
    public int mySqrt(int x) {

        // Brute Force -> o(root of n)
        // long root = 0;
        // for(long i = 0; i <= x; i++){
        //     long square = i * i;
        //     if(square > x) break;
        //     root = i;
            
        // }
        // return (int)root;

        // Method 2 -> o(log n)
        // long low = 0 , high = x;
        // while(low <= high){
        //     long mid = low + high/2;
        //     if(mid*mid == x) return (int)mid;
        //     else if(mid*mid > x) high = mid-1;
        //     else low = mid+1;
        // }
        // return (int)high;

        //Method 3 -> o(log n)
        int low = 1 , high = x;
        if(x == 0) return 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid == x/mid) return mid;
            else if(mid > x/mid) high = mid-1;
            else low = mid+1;
        }
        return high;
    }
}