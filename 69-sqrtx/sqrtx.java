class Solution {
    public int mySqrt(int x) {
        long root = 0;
        for(long i = 0; i <= x; i++){
            long s = i * i;
            if(s > x) break;
            root = i;
            
        }
        return (int)root;
    }
}