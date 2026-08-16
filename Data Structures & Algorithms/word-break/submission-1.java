class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {


        int l = s.length();
        boolean[] dp = new boolean[l+1]; 
        dp[0]=true;
        for(int i=1;i<=l;i++)
        {
            for(String str:wordDict)
            {
                int len = str.length();
                
                if(i>=len && dp[i-len] && s.substring(i-len,i).equals(str))
                {    
                   dp[i]=true;
                   break;
                }
                
            }
          
        }
        return dp[l];
    }
}
