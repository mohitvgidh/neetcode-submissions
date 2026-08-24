class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount+1];
        for(int[] arr:memo)
            Arrays.fill(arr,-1);
        return def(0,amount,coins);
    }
    public int def(int i,int amt,int[] coins)
    {
        if(amt==0)
            return 1;
        if(i==coins.length || amt<0)
            return 0;
        if(memo[i][amt]!=-1)
            return memo[i][amt];
        return memo[i][amt]=def(i,amt-coins[i],coins) + def(i+1,amt,coins);
    }
}
