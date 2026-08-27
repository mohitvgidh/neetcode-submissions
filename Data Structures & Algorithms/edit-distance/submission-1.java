class Solution {
    int [][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        return def(0,0,word1,word2);
    }
    public int def(int i,int j,String word1,String word2)
    {
        if(j>=word2.length())
            return word1.length()-i;
        if(i>=word1.length())
            return word2.length()-j;
        if(memo[i][j]!=-1)
            return memo[i][j];
        int delete=0,replace=0,insert=0;
        if(word1.charAt(i)==word2.charAt(j))
            return memo[i][j]=def(i+1,j+1,word1,word2);
       
        
        //delete
        delete=def(i+1,j,word1,word2);
        //replace
        replace=def(i+1,j+1,word1,word2);
        //insert
        insert=def(i,j+1,word1,word2);
        return memo[i][j]=1+Math.min(delete,Math.min(insert,replace));
        
        
    }
}
