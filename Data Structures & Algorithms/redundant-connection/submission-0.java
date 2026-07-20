class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length+1;
        parent = new int [n];
        rank = new int[n];
        int[] ans= new int[2];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] edge:edges)
        {
            if(!union(edge[0],edge[1]))
            {
                ans[0]=edge[0];
                ans[1]=edge[1]; 
                break;
            }
        }

       return ans; 
    }
    public int find(int node)
    {
        int res=node;
        while(res!=parent[res])
        {
            parent[res]=parent[parent[res]];
            res=parent[res];
        }
        return res;
    }
    public boolean union(int n1,int n2)
    {
        int p1=find(n1);
        int p2=find(n2);
        if(p1==p2)
            return false;
        if(rank[p2]>rank[p1])
        {
            rank[p2]+=rank[p1];
            parent[p1]=p2;
        }
        else
        {
            rank[p1]+=rank[p2];
            parent[p2]=p1;
        }
        return true;
    }

}
