class Solution {
    public int rob(int[] nums) {
        
        int [] rec1 = new int[nums.length];
        int [] rec2 = new int[nums.length];
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(def(0, nums, rec1,n-1),def(1,nums,rec2,n));
        
    }

    public int def(int i, int[] nums, int[] rec,int len) {
        if (i >= len)
            return 0;

        if (rec[i] > 0)
            return rec[i];

        int rob = nums[i] + def(i + 2, nums, rec,len);
        int skip = def(i + 1, nums, rec,len);

        return rec[i] = Math.max(rob, skip);
    }
}
