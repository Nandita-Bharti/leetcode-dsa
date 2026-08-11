class Solution {
    int f(int mid , int m ,int k , int[] bloomDay){
        int n = bloomDay.length , count = 0 , bouquets = 0;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= mid){
                count++;
                if(count == k){
                bouquets++;;
                count = 0;
            }
            }
            else{
                count = 0;
            }
        }
        return bouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length , ans = -1;
        if(n < m*k) return -1;
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max , bloomDay[i]);
            min = Math.min(min , bloomDay[i]);
        }
        int lo = min , hi = max;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            int bouquets = f(mid , m , k , bloomDay);
            if(bouquets >= m){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }
}