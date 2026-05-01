class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1,-1};
        int start = 0 , end = n-1 , idx = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] > target) end = mid-1;
            else if(nums[mid] < target) start = mid+1;
            else{
                idx = mid;
                end = mid-1;
            }
        }
        ans[0] = idx;
        start = 0;
        end = n-1;
        idx = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                idx = mid;
                start = mid+1;
            }
            else if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        ans[1] = idx;
        return ans;
    }
}