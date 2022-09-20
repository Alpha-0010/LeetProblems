class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        // Same as Longest Common Substring.....
        
        int n=nums1.length;
        int m=nums2.length;
        int res=0;
        
        int[][] dp=new int[n+1][m+1];
        
        // Base Case...
        // If there are no elements in one of the arrays and the other one has some
        // elements then the length of common Subarray will be 0.
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        
        // Fill the DP Matrix...
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    res=Math.max(res,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        
        return res;
    }
}