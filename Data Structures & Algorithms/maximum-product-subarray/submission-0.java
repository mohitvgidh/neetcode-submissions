class Solution {
    public int maxProduct(int[] nums) {

        int res= nums[0];
        int curmax=1,curmin=1;
        for(int num:nums)
        {
            int tmp= curmax*num;
            curmax= Math.max(Math.max(tmp,num*curmin),num);
            curmin= Math.min(Math.min(tmp,num*curmin),num);
            res= Math.max(res,curmax);
        }
        return res;
        
    }
}
