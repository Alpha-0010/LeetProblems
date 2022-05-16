class Solution {
    // ...Shortest Path BFS...
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        int level = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        while (queue.size()!=0) {
            int len = queue.size();
            for (int i=0;i<len;i++) {
                int[] node = queue.poll();
                if (node[0] == n-1 && node[1] == m-1) {
                    return level;
                }
                for (int[] dir : dirs) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x<0 || y<0 || x>=n || y>=m || grid[x][y] == 1) {
                        continue;
                    }
                    grid[x][y] = 1;
                    queue.add(new int[]{x,y});
                }
            }
            level++;
        }
        
        return -1;
    }
}