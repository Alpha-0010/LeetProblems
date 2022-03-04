/*

...Top-Down Dynamic Programming...


*/
class Solution {
    int poured;
    Double[][] amtChampagne;
    public double champagneTower(int poured, int query_row, int query_col) {
        this.poured=poured;
        this.amtChampagne=new Double[query_row+1][query_col+1];
        return Math.min(1,dp(query_row,query_col));
    }
    
    // dp(r, c) is the amount of champagne is poured into glass[r, c]
    double dp(int r,int c){
        // Base Cases...
        if(c<0 || c>r){
            return 0;
        }
        if(r==0 && c==0){
            return poured;
        }
        if(amtChampagne[r][c]!=null){
            return amtChampagne[r][c];
        }
        return amtChampagne[r][c]=Math.max(dp(r-1,c-1)-1,0)/2+Math.max(dp(r-1,c)-1,0)/2;
    }
    
}