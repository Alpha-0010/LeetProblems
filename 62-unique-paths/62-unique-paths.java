class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        
        // ...BaseCase...
        for (int i=0;i<n;i++) {
            grid[0][i] = 1;
        }
        for (int i=0;i<m;i++) {
            grid[i][0] = 1;
        }
        
        // ...Fill the DP Matrix...
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        
        return grid[m-1][n-1];
    }
}