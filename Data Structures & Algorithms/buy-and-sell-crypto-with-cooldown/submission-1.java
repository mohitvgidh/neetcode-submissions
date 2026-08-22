class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        
       memo = new int[2][prices.length];
        for(int[] arr:memo)
            Arrays.fill(arr,-1);
        return profit(prices,1,0);
    }
    public int profit(int[] prices,int buy,int i)
    {
        if(i>=prices.length)
            return 0;
        if(memo[buy][i]!=-1)
            return memo[buy][i];
        if(buy==1)
        {

            return memo[buy][i]=Math.max(profit(prices,1,i+1),profit(prices,0,i+1)-prices[i]);
        }
        else
        {
            return memo[buy][i]=Math.max(profit(prices,0,i+1),profit(prices,1,i+2)+prices[i]);
        }
    }
}
