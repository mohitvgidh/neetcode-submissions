class Solution {
    public int jump(int[] nums) {
        int l=0,r=0;
        int maxdist=0;
        int n = nums.length;
        int level=0;
        while(r<n-1){
            while(l<=r)
            {
                maxdist = Math.max(maxdist,l+nums[l]);
                l++;
            }
            l=r+1;
            r=maxdist;
            level++;
        }
        
       return level;     
        
    }
}
