class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q=new LinkedList<int[]>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                q.add(new int[] {i,j});
            }
        }
        if (q.size() == 0) return;

        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };

        while(!q.isEmpty())
        {
            
            
        
                int[] rowcol = q.poll();
                int row = rowcol[0];
                int col= rowcol[1];
                for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= n || c >= m || r < 0 ||
                    c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] { r, c });

                grid[r][c] = grid[row][col] + 1;
                }

        }
    }
}
