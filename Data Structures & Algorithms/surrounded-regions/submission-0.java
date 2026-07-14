class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m =board[0].length;
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O')
                dfs(i,0,board,n,m);
            if(board[i][m-1]=='O')
                dfs(i,m-1,board,n,m);
        }
         for(int j=1;j<m;j++)
        {
            if(board[0][j]=='O')
                dfs(0,j,board,n,m);
            if(board[n-1][j]=='O')
                dfs(n-1,j,board,n,m);
        }
        for(int k=0;k<n;k++)
        {
            for(int l=0;l<m;l++)
            {
                if(board[k][l]=='O')
                    board[k][l]='X';
                if(board[k][l]=='#')
                    board[k][l]='O';
            }
        }


        
    }
    int[][] dist ={{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(int i,int j,char[][] board,int n,int m)
    {
        if(board[i][j]=='#')
            return;
        board[i][j]='#';
        for(int[] dir:dist)
        {
            int rw= i+dir[0];
            int cl=j+dir[1];
            if(rw<n && cl<m && rw>0 && cl>0 && board[rw][cl]=='O')
                dfs(rw,cl,board,n,m);
        }


    }
}
