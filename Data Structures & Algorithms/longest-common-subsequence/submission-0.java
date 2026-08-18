class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        int [][] memo = new int[n][m];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        return dfs(n-1,m-1,text1,text2,memo);
        
    }
    public int dfs(int i,int j,String text1,String text2,int [][] memo)
    {
        if(i<0 || j<0)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(text1.charAt(i)==text2.charAt(j))
            return memo[i][j]=1+dfs(i-1,j-1,text1,text2,memo);
        return memo[i][j]=Math.max(dfs(i-1,j,text1,text2,memo),dfs(i,j-1,text1,text2,memo));
    }
}
