class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i:hand){
            if(!mp.containsKey(i))
                q.offer(i);
            mp.put(i,mp.getOrDefault(i,0)+1);

        }
        while(!q.isEmpty())
        {
            int min = q.peek();
            for(int j=min;j<(min+groupSize);j++)
            {
                if(!mp.containsKey(j))
                    return false;
                mp.put(j,mp.get(j)-1);
                if(mp.get(j)==0)
                {
                    if(j!=q.peek())
                        return false;
                    q.poll();
                    mp.remove(j);
                }
            }
        }
        return true;
        
    }
}
