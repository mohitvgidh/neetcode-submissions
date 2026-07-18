class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1)
            return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        boolean[] visited = new boolean[n];

        boolean ret= dfs(0,-1,adj,visited);
        int count=0;
        for(boolean x:visited)
        {
            if(x)
                count++;
        }
        return ret && count==n;


    }
    public boolean dfs(int i,int parent ,List<List<Integer>> adj,boolean[] visited)
    {
        if(visited[i])
            return false;
        visited[i]=true;
        if(adj.get(i).isEmpty())
            return true;
        
        for(int k: adj.get(i))
        {
        
            if (k==parent)
                continue;
           if(!dfs(k,i,adj,visited))
            return false;
        }
        return true;
    }
}
