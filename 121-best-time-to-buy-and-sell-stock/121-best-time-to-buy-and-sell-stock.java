class Solution {
    public int maxProfit(int[] prices) {
        // The point of interest are peaks and valleys...
        int peak = prices[0];
        int valley = prices[0];
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++) {
            if (prices[i]<valley) {
                valley = prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i]-valley);
            }
        }
        return maxProfit;
    }
}