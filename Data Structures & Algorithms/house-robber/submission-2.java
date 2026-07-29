class Solution {
    public int rob(int[] nums) {
        
        int [] rec = new int[nums.length];
        return def(0,nums,rec);
       

    }
    public int def(int i,int[] nums,int[] rec)
    {
        if(i>=nums.length)
            return 0;
        if(rec[i]>0)
            return rec[i];
        int rob = nums[i]+def(i+2,nums,rec);
        int skip = def(i+1,nums,rec);
        return rec[i]=Math.max(rob,skip);
    }
}
