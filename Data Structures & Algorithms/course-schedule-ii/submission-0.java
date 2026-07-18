class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        int [] indegree= new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites)
        {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int finish=0;
        int[] ans =new int[numCourses];
        while(!q.isEmpty())
        {
            int course =q.poll();
            ans[finish]=course;
            finish++;
            for(int nei: adj.get(course))
            {
                indegree[nei]--;
                if(indegree[nei]==0)
                    q.add(nei);
            }
        }
        return finish==numCourses ? ans:  new int[0];
    }
}


