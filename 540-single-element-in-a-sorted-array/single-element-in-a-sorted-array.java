class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 1 , high = n-2;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        while(lo < high){
            int mid = (lo+high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if(mid != 0 && nums[mid] == nums[mid-1]){
                if(mid % 2 == 0) high = mid-1;
                else lo = mid+1;
            } 
            else if(mid != n-1 && nums[mid] == nums[mid+1]){
                if((n-mid) % 2 != 0) lo = mid+1;
                else high = mid-1;
            }
            else return nums[mid];
        }
        return nums[lo];
    }
}