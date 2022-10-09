class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0,right = m*n-1;
        
        while (left <= right) {
            int pivotIndex = left + (right-left)/2;
            int pivotElement = matrix[pivotIndex/n][pivotIndex%n];
            if (pivotElement == target) {
                return true;
            }else if (pivotElement < target) {
                left = pivotIndex + 1;
            }else {
                right = pivotIndex - 1;
            }
        }
        
        return false;
    }
}