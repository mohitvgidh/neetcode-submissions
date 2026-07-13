class Solution {
    int [][] dist ={{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n=heights.length;
        int m=heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
    dfs(i, 0, heights,n,m,pacific);      // Pacific
    dfs(i, m - 1, heights,n,m,atlantic);  // Atlantic
}

for (int j = 0; j < m; j++) {
    dfs(0, j, heights,n,m,pacific);      // Pacific
    dfs(n - 1, j, heights,n,m,atlantic);  // Atlantic
}
for(int i=0;i<n;i++)
{
    for(int j=0;j<m;j++)
    {
        if(atlantic[i][j] && pacific[i][j])
        {
            
            ret.add(Arrays.asList(i, j));
        }
    }
}
return ret;

    }
    public void dfs(int r,int c,int[][] heights,int n,int m,boolean[][] visited)
    {
        if (visited[r][c]) {
            return;
        }
        visited[r][c]=true;
        for(int[] dir:dist)
        {
            int rc=r+dir[0];
            int cl=c+dir[1];
            if(rc<n && cl<m && rc>=0 && cl>=0 && heights[r][c]<=heights[rc][cl])
            {
                dfs(rc,cl,heights,n,m,visited);
            }
        }
        
    }
}
