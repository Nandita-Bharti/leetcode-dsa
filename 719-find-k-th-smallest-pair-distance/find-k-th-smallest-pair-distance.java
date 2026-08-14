class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length , ans = 0;
        int lo = 0 , hi = nums[n-1]-nums[0];
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(countPairs(mid , nums , k) >= k){
                hi = mid-1;
                ans = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }
    int countPairs(int mid ,int[] nums , int k){
        int i = 0 , count = 0;
        for(int j = 0; j < nums.length; j++){
            while(nums[j]-nums[i] > mid){
                i++;
            }
            count += j-i;
        }
        return count;
    }
}