class Solution {
    public void rotate(int[][] matrix) {
        // First take transpose of the matrix and then horizontanly reverse it...
        int rows = matrix.length;
        if (rows == 0) {
            return;
        }
        int cols = matrix[0].length;
        
        // Step-1: Transpose(swap(matrix[i][j],matrix[j][i])).
        for (int i=0;i<rows;i++) {
            for (int j=i+1;j<cols;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step-2: Reverse it horizontally.
        for (int i=0;i<rows;i++) {
            int left = 0,right = rows-1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = temp;
            }
        }
    }
}