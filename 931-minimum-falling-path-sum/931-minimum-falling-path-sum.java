/*

(i,j) -> (i-1,j) (i-1,j-1) (i-1,j+1)

*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i=1;i<m;i++) {
            for (int j=0;j<n;j++) {
                int tempAns = matrix[i-1][j];
                if (j>0) {
                    tempAns = Math.min(tempAns,matrix[i-1][j-1]);
                }
                if (j<n-1) {
                    tempAns = Math.min(tempAns,matrix[i-1][j+1]);
                }
                matrix[i][j] += tempAns;
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for (int i=0;i<n;i++) {
            res = Math.min(res,matrix[m-1][i]);
        }
        
        return res;
    }
}