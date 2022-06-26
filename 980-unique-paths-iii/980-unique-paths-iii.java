class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sx = 0, sy = 0;
        int cnt = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    sx = i; sy= j;
                }else if (grid[i][j] != -1) {
                    cnt++;
                }
            }
        }
        return dfs(grid,sx,sy,cnt,0);
    }
    
    private int dfs (int[][] grid,int sx,int sy,int cnt,int steps) {
        /*...Base Case...*/
        if (sx<0 || sy<0 || sx>=grid.length || sy>=grid[0].length || grid[sx][sy] == -1) {
            return 0;
        }
        if (grid[sx][sy] == 2 && steps == cnt) {
            return 1;
        }
        if (grid[sx][sy] == 2){
            return 0;
        }
        grid[sx][sy] = -1;
        int res = dfs(grid,sx+1,sy,cnt,steps+1) + dfs(grid,sx-1,sy,cnt,steps+1) + dfs(grid,sx,sy+1,cnt,steps+1) + dfs(grid,sx,sy-1,cnt,steps+1);
        grid[sx][sy] = 0;
        return res;
    }
    
}