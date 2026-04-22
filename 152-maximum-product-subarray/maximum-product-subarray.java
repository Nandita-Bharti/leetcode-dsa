class Solution {
    public int maxProduct(int[] nums) {
        int pref = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;
            pref = pref*nums[i];
            suff = suff*nums[n-1-i];
            ans = Math.max(ans , Math.max(suff,pref));
        }
        return ans;
    }
}