class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(isPalindrome(i,j,s,memo))
                    cnt++;
            }
        }
        return cnt;
    }
    public boolean isPalindrome(int i,int j, String s,boolean[][] memo)
    {
        if(i>=j)
            return true;
        if(memo[i][j])
            return memo[i][j];
        return memo[i][j]=(s.charAt(i)==s.charAt(j) && isPalindrome(i+1,j-1,s,memo));
    }
}
