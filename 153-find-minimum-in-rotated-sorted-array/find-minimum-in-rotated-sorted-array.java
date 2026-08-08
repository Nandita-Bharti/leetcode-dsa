class Solution {
    public int findMin(int[] nums) {
        int n = nums.length , ans = Integer.MAX_VALUE;
        int lo = 0 , hi = n-1;
        if(n == 1) return nums[0];
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[lo] <= nums[mid]){
                ans = Math.min(ans , nums[lo]);
                lo = mid+1;
            }
            else{
                ans = Math.min(ans , nums[mid]);
                hi = mid-1;
            }
        }
        return ans;
    }
}