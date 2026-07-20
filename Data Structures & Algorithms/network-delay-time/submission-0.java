class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        List<List<int[]>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] time: times)
        {
            adj.get(time[0]).add(new int[]{time[2],time[1]});
        }
        queue.offer(new int[]{0,k});
        int res=0;
        while(!queue.isEmpty())
        {
            int[] timenode = queue.poll();
            if(!visited[timenode[1]])
            {
                res = Math.max(res,timenode[0]);
                visited[timenode[1]]=true;
                for(int[] nei:adj.get(timenode[1]))
                {
                   
                     queue.offer(new int[]{timenode[0]+nei[0],nei[1]});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                return -1;
        }
        return res;
        
    }
}
