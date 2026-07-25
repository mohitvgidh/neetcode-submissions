class Solution {

    class Edge{
        int r;
        int c;
        int maxm;
        public Edge(int m,int rc,int cl)
        {
            r=rc;
            c=cl;
            maxm=m;
        }
    }
    public int swimInWater(int[][] grid) {
        
        int n= grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Edge> q = new PriorityQueue<>((a,b)-> a.maxm-b.maxm);
        q.offer(new Edge(grid[0][0],0,0));
        int[][] dist ={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            
            Edge e = q.poll();
            if(e.r == n-1 && e.c== m-1)
                return e.maxm;
            if(!visited[e.r][e.c])
            {    
                visited[e.r][e.c]=true;
                for(int[] dir :dist){
                    int rc = e.r+dir[0];
                    int cl= e.c+dir[1];
                    if(rc<n && cl<m && rc>=0 && cl>=0)
                        q.offer(new Edge(Math.max(e.maxm,grid[rc][cl]),rc,cl));
                }
            }

        }
       return -1; 
    }
}
