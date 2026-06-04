class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
    
        for(int ele : candies){
            if(ele > max) max = ele;
            sum += ele;
        }
        if(sum < k) return 0;
        int low = 1 , high = max , ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(child(mid,candies) >= k){
                low = mid+1;
                ans = mid;   //child ko inc krna h to candies kam hoga
            }
            else{
                high = mid-1;
            } 
        }
        return ans;
    }
    long child(int mid , int[] candies){
        long calc_child = 0;
        for(int ele : candies){
            calc_child += ele/mid;
        }
        return calc_child;
    }
}