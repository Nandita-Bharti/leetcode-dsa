class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int i = 0, j = 0;
        int n = nums.length;
        if(n == 2 && nums[0] == 0 && nums[1] == 1) return 1;
        while( j < n ){
            if(nums[i] == 1 && nums[j] == 1){
                count++;
                maxCount = Math.max(maxCount,count);
            }
            else{
                count = 1;
                i = j;
            }
            j++;
        }
        return maxCount;
    }
}