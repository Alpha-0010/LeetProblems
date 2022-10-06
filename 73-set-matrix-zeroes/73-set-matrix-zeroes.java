class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean firstRowContainsZero = false;
        
        // Check if the first row contains a zero.
        for (int i=0;i<m;i++) {
            if (matrix[0][i] == 0) {
                firstRowContainsZero = true;
            }
        }
        
        // Mark the cells of first row as zero which have a zero in their column.
        for (int i=1;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Now visit all the cells except the cells of the first row and mark them accordingly.
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
        
        // Now mark the unvisited first row accordingly.
        for (int i=0;i<m;i++) {
            if (firstRowContainsZero) {
                matrix[0][i] = 0;
            }
        }
    }
}