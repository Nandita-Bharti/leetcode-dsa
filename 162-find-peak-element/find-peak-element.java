class Solution {
    public int findPeakElement(int[] nums) {

        int lo = 0;
        int high = nums.length - 1;

        while(lo < high){

            int mid = lo + (high - lo) / 2;

            if(nums[mid] < nums[mid + 1]){
                lo = mid + 1;
            }
            else{
                high = mid;
            }
        }

        return lo;
    }
}