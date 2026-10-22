class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        int n=candidates.length;
        Arrays.sort(candidates);
        return def(candidates,target,0,n);

    }
    public List<List<Integer>> def(int[] candidates,int target,int i,int n){


        if(target==0)
        {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            result.add(res);
            return result;
        }
        if(i==n || target<0)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> res=def(candidates,target-candidates[i],i+1,n);
        for(List<Integer> l: res)
        {
            l.add(candidates[i]);
            result.add(l);
        }
        int j=i+1;
        while(j<n && candidates[j]==candidates[i])
        {
            j++;
        }
        List<List<Integer>> res2=def(candidates,target,j,n);
        result.addAll(res2);
        return result;
    }
}
