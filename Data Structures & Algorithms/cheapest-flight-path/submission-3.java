class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> mp = new HashMap<>();
        int[][] dist = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][src] = 0;
        for(int i=0;i<flights.length;i++)
        {
            mp.computeIfAbsent(flights[i][0],l->new ArrayList<>()).add(new int[]{flights[i][2],flights[i][1]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,src,0});
        int cost=0;
        int moves=0;
        int res=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int[] x = q.poll();
            moves = x[2];

            
            cost = x[0];
            if (cost > dist[moves][x[1]]) {
    continue;
}
            if(x[1]==dst)
            {
                res=Math.min(res,cost);
                continue;
            }
            if (moves == k+1)
                continue;
            List<int[]> neighbors = mp.getOrDefault(x[1], Collections.emptyList());
            for(int [] get : neighbors){
             int newCost = cost + get[0];
int next = get[1];

if (newCost < dist[moves + 1][next]) {
    dist[moves + 1][next] = newCost;
    q.offer(new int[]{newCost, next, moves + 1});
}
       }
            
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
