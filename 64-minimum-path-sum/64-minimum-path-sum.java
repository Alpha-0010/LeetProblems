class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        //...Base Case...
        dp[0][0] = grid[0][0];
        for (int i=1;i<n;i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for (int i=1;i<m;i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        
        //...Fill the DP Matrix...
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                int ans1 = grid[i][j] + dp[i-1][j];
                int ans2 = grid[i][j] + dp[i][j-1];
                dp[i][j] = Math.min(ans1,ans2);
            }
        }
        
        return dp[m-1][n-1];
    }
}