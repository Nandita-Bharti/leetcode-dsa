class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0 , high = n-1;
        while(lo <= high){
            int mid = (lo + high)/2;
            if(nums[mid] == target) return mid;
            //check left half is sorted or not (low to mid)
            else if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && target < nums[mid]) high = mid-1;
                else lo = mid+1;
            } 
            else{
                if(nums[mid] < target && target <= nums[high]) lo = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}