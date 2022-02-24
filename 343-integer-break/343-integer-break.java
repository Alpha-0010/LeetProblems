/*

Unbounded Knapsack--> Rod Cutting.........
https://leetcode.com/problems/integer-break/discuss/1434210/CPP-JAVA-Recursion-greater-Memoization-(0-ms)-greater-bottom-up-(0-ms)

i runs till n-1 becuase we have to divide the array into atleast 2 parts.....

*/
class Solution {
    public int integerBreak(int n) {
        int[][] dp=new int[n][n+1];
        
        /*...Base Case...*/
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=1;
        }
        
        /*...Now fill the DP Matrix...*/
        for(int i=1;i<n;i++){
            for(int j=1;j<n+1;j++){
                // ...Typical Unbounded Knapsack step...
                if(j>=i){
                    dp[i][j]=Math.max(dp[i-1][j],i*dp[i][j-i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][n];
    }
}