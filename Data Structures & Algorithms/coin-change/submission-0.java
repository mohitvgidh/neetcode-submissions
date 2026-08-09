class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [][] memo = new int[coins.length][amount+1];
        for(int [] arr : memo)
            Arrays.fill(arr,-1);
        int dat =cnt(0,coins,amount,memo);
        return dat == Integer.MAX_VALUE? -1: dat;
    }
    public int cnt(int i,int[] coins,int amt,int [][] memo)
    {
       
        if(amt == 0)
            return 0;
        if(i==coins.length || amt<0)
            return Integer.MAX_VALUE;
        if(memo[i][amt]!=-1)
            return memo[i][amt];
        int take = cnt(i, coins, amt - coins[i],memo);

        if (take != Integer.MAX_VALUE)
            take = 1 + take;
        int skip = cnt(i + 1, coins, amt,memo);

        return memo[i][amt] = Math.min(take, skip);
    }
}
