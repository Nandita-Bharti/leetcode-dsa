class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int buyCost = prices[0];
        for(int i = 1; i < n; i++){
            int sellProfit = prices[i] - buyCost;
            maxProfit = Math.max(maxProfit,sellProfit);
            buyCost = Math.min(buyCost,prices[i]);
        }
        return maxProfit;
    }
}