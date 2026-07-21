class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String,PriorityQueue<String>> mp = new HashMap<>();
        for(List<String> ticket:tickets)
        {
            mp.computeIfAbsent(ticket.get(0),k-> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> visited = new ArrayList<>();
        dfs("JFK",mp,visited);
        
        Collections.reverse(visited);
        return visited;

    }
    public void dfs(String s,Map<String,PriorityQueue<String>> mp, List<String> visited)
    {
       PriorityQueue<String> p = mp.get(s);
       while(p!=null && !p.isEmpty())
       {
          String g = p.poll();
          dfs(g,mp,visited);    
       }
       visited.add(s);
    }
}
