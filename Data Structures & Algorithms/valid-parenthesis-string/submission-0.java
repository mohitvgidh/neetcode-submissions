class Solution {
   
    public boolean checkValidString(String s) {

        Stack<Integer> charac = new Stack<>();
        Stack<Integer> ast = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
          if(s.charAt(i)=='(')
            charac.push(i);
          if(s.charAt(i)=='*')
            ast.push(i);
           if(s.charAt(i)==')' ){
            if(!charac.isEmpty())
                 charac.pop();
            else if(!ast.isEmpty())
                ast.pop();
            else
                return false;
           }
        }
        while(!charac.isEmpty())
        {
            if(ast.isEmpty())
                return false;
            int x = charac.pop();
            int y = ast.pop();
            if(x>y)
                return false;

        }
        return true;
        
    }
}
