class Solution {
       int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int maxl =0;
         int n= matrix.length;
        int m = matrix[0].length;
         memo = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                maxl=Math.max(dfs(i,j,matrix),maxl);
            }
        }
        return maxl;
    }
    public int  dfs(int i,int j,int [][] matrix)
    {
        int n= matrix.length;
        int m = matrix[0].length;
        if(i>=n ||i<0||j>=m||j<0)
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        
        int left=0,right=0,top=0,bottom=0;
        if(i+1<n && matrix[i][j]<matrix[i+1][j])
            bottom=dfs(i+1,j,matrix);
        if(j+1<m && matrix[i][j]<matrix[i][j+1])
            right=dfs(i,j+1,matrix);
        if(i>0 && matrix[i][j]<matrix[i-1][j])
            top=dfs(i-1,j,matrix);
        if(j>0 && matrix[i][j]<matrix[i][j-1])
            left=dfs(i,j-1,matrix);
        return memo[i][j]=1+Math.max(bottom,Math.max(top,Math.max(left,right)));
        
       
    }
}
