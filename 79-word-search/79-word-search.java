class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j]==word.charAt(0) && dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board,String word,int x,int y,int idx) {
        // ...Base Case...
        
        if (idx == word.length()) {
            return true;
        }
        
        if (x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!=word.charAt(idx)) {
            return false;
        }
        
        char temp = board[x][y];
        board[x][y] = '#';
        boolean res = dfs(board,word,x+1,y,idx+1) || dfs(board,word,x-1,y,idx+1) || dfs(board,word,x,y+1,idx+1) || dfs(board,word,x,y-1,idx+1);
        board[x][y] = temp;
        return res;
    }
    
}