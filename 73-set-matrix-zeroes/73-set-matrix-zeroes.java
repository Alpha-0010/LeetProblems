class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Check if the first row has a Zero...
        boolean isFirstRowZero = false;
        for (int j=0;j<m;j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
            }
        }
        
        // Now fill the cells of first row with Zero if the correspoding column has a zero...
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Traverse over the remaining matrix and mark the cells...
        for (int i=1;i<n;i++) {
            boolean rowContainsZero = false;
            for (int j=0;j<m;j++) {
                if (matrix[i][j] == 0) {
                    rowContainsZero = true;
                }
            }
            for (int j=0;j<m;j++) {
                if (rowContainsZero || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Now mark the required cells of row 0 with Zeros...
        for (int j=0;j<m;j++) {
            if (isFirstRowZero || matrix[0][j] == 0) {
                matrix[0][j] = 0;
            }
        }
    }
}