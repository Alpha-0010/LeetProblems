class Solution {
    public int maxProfit(int[] prices) {
        // The point of interest are peaks and valleys...
        int peak = prices[0];
        int valley = prices[0];
        int profit = 0;
        
        for (int price : prices) {
            if (price < valley) {
                valley = price;
            }else {
                profit = Math.max(profit,price - valley);
            }
        }
        
        return profit;
    }
}