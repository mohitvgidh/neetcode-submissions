class Solution {
    private Boolean[][] memo;
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int maxlen = 0;
        int start=0;
        memo = new Boolean[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(def(i,j,s))
                {
                    int len = j-i+1;
                    if(len>maxlen)
                    {
                        start=i;
                        maxlen=len;
                    }
                }
            }
        }
        return s.substring(start,start+maxlen);
    }
    public boolean def(int i,int j,String s)
    {
        if(i>=j)
            return true;
        if(memo[i][j] != null)
            return memo[i][j];

        if(s.charAt(i) != s.charAt(j))
            return memo[i][j] = false;

        return memo[i][j] = def(i+1,j-1,s);
    }
}
