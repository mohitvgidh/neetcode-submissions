class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> h = new HashMap<>();
        for(String s:strs)
        {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String res = String.valueOf(charArray);
            // System.out.println(res);
            h.putIfAbsent(res,new ArrayList<String>());
            h.get(res).add(s);
        }
        return new ArrayList<>(h.values());
        
    }
}
