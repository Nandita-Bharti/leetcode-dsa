class Solution {
    public int removeDuplicates(int[] nums) {
        int x = 2;
        int n = nums.length;
        if(n <= 2) return n;
        for(int j = 2; j < n; j++){
            if(nums[j] != nums[x-2]){
                nums[x] = nums[j];
                x++;
            }
        }
        return x;
    }
}