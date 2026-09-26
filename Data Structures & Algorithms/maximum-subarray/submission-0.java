class Solution {
    public int maxSubArray(int[] nums) {
        int sumtillhere=nums[0],maxsum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sumtillhere=Math.max(nums[i],sumtillhere+nums[i]);
            maxsum=Math.max(maxsum,sumtillhere);
        }
        return maxsum;
        
    }
}
