class Solution {
    public int orangesRotting(int[][] grid) { 

        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int minutes=0;
        int fresh=0;
        for(int i=0;i<n;i++ )
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        int[][] dir = {
    {1, 0},
    {0, 1},
    {-1, 0},
    {0, -1}
};
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int k=0;k<size;k++)
            {
                int[] rowcol = q.poll();
                int rw= rowcol[0];
                int cl=rowcol[1];
                for(int[] d:dir)
                {
                    int r = rw+d[0];
                    int c = cl+d[1];
                    if(r<n && c<m && r>=0 && c>=0 && grid[r][c]==1)
                    {
                        System.out.println("prev "+grid[r][c]);
                        grid[r][c]=2;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }
            }
            if(q.size()>0)
                minutes++;
        }
        return fresh == 0 ? minutes : -1;                                                                                          
        
    }
}
