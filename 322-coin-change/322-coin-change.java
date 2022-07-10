class Solution {
    static int INF=(int)1e9+5;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] cache = new int[n+1][amount+1];
        
        // ...Base Case...
        for (int i=1;i<amount+1;i++) {
            cache[0][i] = INF;
        }
        for (int i=1;i<n+1;i++) {
            cache[i][0] = 0;
        }
        cache[0][0] = 0;
        
        // Fill the DP Matrix...
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<amount+1;j++) {
                if (coins[i-1]<=j) {
                    cache[i][j] = Math.min(cache[i-1][j],1+cache[i][j-coins[i-1]]);
                }else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[n][amount] == INF ? -1 : cache[n][amount];
    }
}