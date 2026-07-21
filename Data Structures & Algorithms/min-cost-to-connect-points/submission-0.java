class Solution {
    int[] parent;
    int[] rank;
    class Edge{
    int u;
    int v;
    int cost;

    Edge(int u,int v,int cost){
        this.u=u;
        this.v=v;
        this.cost=cost;
    }
}
    public int find(int node)
    {
        int res=node;
        while(res !=parent[res])
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
        if(rank[p1]>rank[p2])
        {
            parent[p2]=p1;
            rank[p1]+=rank[p2];
        }
        else
        {
            parent[p1]=p2;
            rank[p2]+=rank[p1];
        }
        return true;
    }


    public int minCostConnectPoints(int[][] points) {

        
        int n=points.length;
        parent = new int[n];
        rank = new int[n];
        
       List<Edge> edges = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
            for(int j=i+1;j<n;j++)
            {
              
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new Edge(i,j,dist));
            }
        }
        Collections.sort(edges,(a,b)->a.cost-b.cost);
        int result=0;
        for(Edge e: edges)
        {
            if(union(e.u,e.v))
                result+=e.cost;
        }
        return result;
    }
}
