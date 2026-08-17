class Solution {
    public boolean canPartition(int[] nums) {
        

        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        if(sum%2!=0) return false;
        return dfs(0,sum/2,nums);

    }
    public boolean dfs(int i,int sum,int[] nums)
    {

        if(sum==0)
            return true;
        if(i>=nums.length)
            return false;
        return dfs(i+1,sum-nums[i],nums) || dfs(i+1,sum,nums);
    }
}
