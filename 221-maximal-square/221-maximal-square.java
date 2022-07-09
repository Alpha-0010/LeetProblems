/*
To add any cell(i,j) to a square matrix we need to check if we can extend it in the
left with all ones and up with all ones. So at any (i,j) cell maximum square matrix
that it can form will be 1+min(squareMatrix(i-1,j-1),squareMatrix(i-1,j),squareMatrix(i,j-1)).
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = 0;
        
        int[][] dp = new int[m][n];
        
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        
        size = matrix[0][0] == '1' ? 1 : 0;
        
        /// Base Case...
        for (int i=1;i<n;i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                size = 1;
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i=1;i<m;i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                size = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        
        // ...Fill the DP Matrix...
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
                size = Math.max(size,dp[i][j]);
            }
        }
        
        return size * size;
    }
}