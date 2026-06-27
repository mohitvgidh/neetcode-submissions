class Solution {
    public int numIslands(char[][] grid) {

        int n= grid.length;
        int m =grid[0].length;
        int[][] visited=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cnt+=def(i,j,visited,grid,n-1,m-1);
            }
        }
        return cnt;   
    }

    public int def(int i,int j,int[][] visited,char[][] grid,int n,int m)
    {
        if(grid[i][j]=='1' && visited[i][j]==0)
        {
            visited[i][j]=1;
            if(i<n)
                def(i+1,j,visited,grid,n,m);
            if(j<m)
                def(i,j+1,visited,grid,n,m);
            if(i>0)
                def(i-1,j,visited,grid,n,m);
            if(j>0)
                def(i,j-1,visited,grid,n,m);
            return 1;
        }
        return 0;
        
    }
}
