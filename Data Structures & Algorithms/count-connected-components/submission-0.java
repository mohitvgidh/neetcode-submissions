class Solution {
    public int countComponents(int n, int[][] edges) {

          List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res=0;
        for(int nod=0;nod<n;nod++)
        {
            if(!visit[nod])
            {
                dfs(nod,visit,adj);
                res++;
            }
        }
        return res;


    }
    public void dfs(int node,boolean[] visit,List<List<Integer>> adj)
    {
        visit[node]=true;
        for(int nei:adj.get(node))
        {
            if(!visit[nei])
            {
                dfs(nei,visit,adj);
            }
        }
    }
}
