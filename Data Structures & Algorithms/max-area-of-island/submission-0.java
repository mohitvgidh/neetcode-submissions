class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m =grid[0].length;
        int[][] visited=new int[n][m];
        int mx=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int[] tmp = new int[1];
                def(i,j,visited,grid,n-1,m-1,tmp);
                mx=Math.max(mx,tmp[0]);
            }
        }
        return mx;   
    }

    

    public void def(int i,int j,int[][] visited,int[][] grid,int n,int m,int[] cnt)
    {
        if(grid[i][j]==1 && visited[i][j]==0)
        {
            visited[i][j]=1;
            cnt[0]=cnt[0]+1;
            if(i<n)
                def(i+1,j,visited,grid,n,m,cnt);
            if(j<m)
                def(i,j+1,visited,grid,n,m,cnt);
            if(i>0)
                def(i-1,j,visited,grid,n,m,cnt);
            if(j>0)
                def(i,j-1,visited,grid,n,m,cnt);
        }
    }
}


