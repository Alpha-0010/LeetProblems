class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        // 4-pointers...
        
        int rowBegin = 0, colBegin = 0, rowEnd = matrix.length-1 , colEnd = matrix[0].length-1;
        
        while (rowBegin<=rowEnd && colBegin<=colEnd) {
            // ...First Row...
            for (int i=colBegin;i<=colEnd;i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            // ...Last Col...
            for (int i=rowBegin;i<=rowEnd;i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            // ...Last Row...
            if (rowBegin<=rowEnd) {
                for (int i=colEnd;i>=colBegin;i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // ...First Col...
            if (colBegin<=colEnd) {
                for (int i=rowEnd;i>=rowBegin;i--) {
                    result.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        
        return result;
    }
}