class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> adj = new HashMap<>();
      int n= words.length;
      for (String w : words) {
    for (char c : w.toCharArray()) {
        adj.putIfAbsent(c, new ArrayList<>());
    }
}
      for(int i=0;i<n-1;i++)
      {
        int minlen= Math.min(words[i].length(),words[i+1].length());
        if(words[i].substring(0,minlen).equals(words[i+1].substring(0,minlen)) && words[i].length()>words[i+1].length())
         return "";
        for(int k=0;k<minlen;k++)
        {
            if(words[i].charAt(k)!=words[i+1].charAt(k))
            {    adj.computeIfAbsent(words[i].charAt(k),l->new ArrayList<>()).add(words[i+1].charAt(k));
                break;
            }
            
        }
      }
      HashMap<Character,Boolean> visited = new HashMap<>();
      List<Character> res = new ArrayList<>();
      for(Map.Entry<Character,List<Character>> ent: adj.entrySet())
      {
        if(dfs(ent.getKey(),adj,visited,res))
            return "";
      }
      Collections.reverse(res);
      StringBuilder sb = new StringBuilder();

for(char c : res)
    sb.append(c);

return sb.toString();
      
    }
    public boolean dfs(char c,  Map<Character,List<Character>> adj,HashMap<Character,Boolean> visited,List<Character> res)
    {
        if(visited.containsKey(c))
         return visited.get(c);
        visited.put(c,true);
        for(char nei:adj.get(c))
        {
            if (dfs(nei, adj, visited, res))
                return true;
        }
        res.add(c);
        visited.put(c,false);
        return false;

    }
}
