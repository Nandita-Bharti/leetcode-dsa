class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1 , high = 10000000 , speed = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(totalHours(mid,dist) <= hour){
                speed = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return speed;
    }
        double totalHours(int mid , int[] dist){
        double calc_hour = 0;
        int n = dist.length;
        for(int i = 0; i < n-1; i++){
            calc_hour += Math.ceil((double)dist[i] / (double)mid);
        }
        calc_hour += (double)dist[n-1]/mid;
        return calc_hour;
    }
}