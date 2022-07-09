class Solution {
    
    // For each row store the minimum element and the second minimum element
    // because if the index of minimum element and the curr element is same then we can't
    // add them in that case we will add the second minimum element to the current
    // row element.
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        
        int minimum=0,secondMinimum=0,pos=-1;
        
        for (int i=0;i<n;i++) {
            int smallMinimum = Integer.MAX_VALUE, secondSmallMinimum = Integer.MAX_VALUE, pos1= -1;
            for (int j=0;j<n;j++) {
                int curr = arr[i][j] + (pos == j ? secondMinimum : minimum);
                if (curr < smallMinimum) {
                    secondSmallMinimum = smallMinimum;
                    smallMinimum = curr;
                    pos1 = j;
                }else {
                    secondSmallMinimum = Math.min(secondSmallMinimum,curr);
                }
            }
            minimum = smallMinimum;
            secondMinimum = secondSmallMinimum;
            pos = pos1;
        }
        
        return minimum;
    }
}