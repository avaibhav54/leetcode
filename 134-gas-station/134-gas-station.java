class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sg=0;
        for(int x:gas)sg+=x;
        int sc=0;
        for(int x:cost)sc+=x;
        if(sc>sg)return -1;
        int ans=0;
        int rem=0;
        for(int i=0;i<gas.length;i++)
        {
            rem+=gas[i]-cost[i];
            if(rem<0)
            {
                ans=i+1;rem=0;
            }
        }
        return ans;
    }
    public static boolean chk(int gas[],int cost[],int i)
    {
        int n=gas.length;
        int st=0;
        
        for(int k=0;k<gas.length;k++)
        {
            st+=gas[(i+k)%n]-cost[(i+k)%n];
            if(st<0)return false;
        }
        return true;
    }
}