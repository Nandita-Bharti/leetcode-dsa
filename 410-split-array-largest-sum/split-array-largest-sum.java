class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0 , n = nums.length , max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(nums[i] > max) max = nums[i];
        }
        int high = sum , low = max;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canDivide(nums , mid , n) > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
    int canDivide(int[] nums , int mid, int n){
        int sum = 0 , count = 1;
        for(int i = 0; i < n; i++){
            if(sum+nums[i] <= mid){
                sum+=nums[i];
            }
            else{
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}