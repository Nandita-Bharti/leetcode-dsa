class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int i = 0 , count = 0 , prod = 1 , n = nums.length;
        for(int j = 0; j < n; j++){
            prod *= nums[j];
                while(prod >= k){
                    prod = prod/nums[i];
                    i++;
                }
            count += j-i+1;

        } 
        return count;     
    }
}