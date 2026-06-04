class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int ele : piles){
            if(ele > max) max = ele;
        }
        int low = 1 , high = max , speed = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(totalHours(mid,piles) <= h){
                speed = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return speed;
    }
    long totalHours(int mid , int[] piles){
        long cal_hour = 0;
        for(int ele : piles){
            if(ele % mid != 0){
                cal_hour += ele/mid+1; 
            }
            else cal_hour += ele/mid;
        }
        return cal_hour;
    }
}