class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] memo = new int[m+1][n+1];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        return grid(0,0,m-1,n-1,memo);
    }
    public int grid(int i,int j,int m,int n,int[][] memo)
    {
        if(i==m && j==n)
            return 1;
        if(memo[i][j]!=-1)
            return memo[i][j];
        int down = 0,right=0;
        if(i<m)
           down= grid(i+1,j,m,n,memo);
        if(j<n)
           right= grid(i,j+1,m,n,memo);
        return memo[i][j]=down+right;
    }
}
