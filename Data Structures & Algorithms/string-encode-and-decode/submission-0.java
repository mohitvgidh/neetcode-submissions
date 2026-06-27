class Solution {

    public String encode(List<String> strs) {

        StringBuilder b =new StringBuilder();
        for(String str:strs)
        {
            b.append(str.length()).append("#").append(str);
            
        }
        return b.toString();

    }

    public List<String> decode(String str) {

        List<String> l = new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int j=i;
            while(str.charAt(j)!='#')
                j++;

            int len = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+len;
            l.add(str.substring(i,j));
            i=j;
        }
        return l;

    }
}
