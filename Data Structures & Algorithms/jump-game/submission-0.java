class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int hot =nums[n-1];
        for(int i=n-1;i>=0;i--)
        {
            if(i+nums[i]>=hot)
            {
                hot=i;
            }
        }
        if(hot==0)
            return true;
        return false;
    }
}
