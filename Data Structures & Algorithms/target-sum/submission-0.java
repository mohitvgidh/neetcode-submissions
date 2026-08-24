class Solution {
    int[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        memo = new int[nums.length][2 * sum + 1];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        return def(0,nums,0,target,sum);
    }
    public int def(int i,int[] nums,int t,int tar,int sum)
    {
        if(i==nums.length && t==tar)
            return 1;
        if(i>=nums.length)
            return 0;
        if(memo[i][t+sum]!=-1)
            return memo[i][t+sum];
        return memo[i][t+sum]=def(i+1,nums,t-nums[i],tar,sum)+def(i+1,nums,t+nums[i],tar,sum);
    }
}
