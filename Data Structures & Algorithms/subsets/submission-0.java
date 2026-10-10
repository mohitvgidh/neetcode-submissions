class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        return def(0,n,nums);

    }
    public List<List<Integer>> def(int i,int n,int[] num){
        if(i==n)
        {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> ret = new ArrayList<>();
            res.add(ret);
            return res;
        }
        List<List<Integer>> lt = def(i+1,n,num);
        int size = lt.size();

        for (int j = 0; j < size; j++) {
           List<Integer> newList = new ArrayList<>(lt.get(j));;
           newList.add(num[i]);
           lt.add(newList);
        }
        return lt;

    }
}
