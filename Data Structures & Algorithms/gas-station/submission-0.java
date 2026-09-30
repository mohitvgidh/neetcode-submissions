class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int start=0,gasneeded=0,currgas=0;
        int n=gas.length;
        int i=0;
        while(i<n)
        {
            currgas+=(gas[i]-cost[i]);
            //System.out.println(currgas);
            if(currgas<0)
            {
                start=i+1;
                //System.out.println(start);
                gasneeded+=currgas;
                currgas=0;
            }
            i++;
        }
        if(currgas+gasneeded>=0)
            return start;
        return -1;
        
    }
}
