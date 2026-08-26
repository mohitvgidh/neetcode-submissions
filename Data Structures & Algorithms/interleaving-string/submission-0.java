class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        memo= new int[s1.length()+1][s2.length()+1];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        return def(0,0,s1,s2,s3);
    }
    public boolean def(int i,int j,String s1, String s2, String s3)
    {
        if(i==s1.length() && j==s2.length())
            return true;
        if(memo[i][j]!=-1)
            return memo[i][j]==1;
        boolean result = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){

            result=def(i+1,j,s1,s2,s3);
        }
        if(!result && j<s2.length() && s2.charAt(j)==s3.charAt(i+j))
            result=def(i,j+1,s1,s2,s3);
        memo[i][j]=result?1:0;
        return result;
    }
}
