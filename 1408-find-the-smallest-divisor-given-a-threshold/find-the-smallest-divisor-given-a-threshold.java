class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int ele : nums){
            if(ele > max) max = ele;
        }
        int low = 1 , high = max , ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(findSum(mid,nums) <= threshold){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    int findSum(int mid , int[] nums){
        int sum = 0;
        for(int ele : nums){
            sum += (ele + mid - 1) / mid;
        }
        return sum;
    }
}