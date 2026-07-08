class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxi = 1;
        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] > nums[prev] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    cnt[i] = cnt[prev];

                }
                else if(nums[i] > nums[prev] && dp[prev] + 1 == dp[i]) {
                    cnt[i] += cnt[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == maxi) ans += cnt[i];
        }
        return ans;
    }
}