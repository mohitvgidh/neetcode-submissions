class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        return def(nums,target,0,nums.length);
    }
    public List<List<Integer>> def(int[] num,int tar,int i,int n)
    {
        if(tar==0)
        {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> r = new ArrayList<>();
            result.add(r);
            return result;
        }
        if(i==n || tar<0)
            return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> lt =def(num,tar-num[i],i,n);
        for(List<Integer> l:lt)
        {
            List<Integer> newl= new ArrayList<>(l);
            newl.add(num[i]);
            res.add(newl);
        }

        List<List<Integer>> rt =def(num,tar,i+1,n);
        res.addAll(rt);
        return res;
        
    }
}
