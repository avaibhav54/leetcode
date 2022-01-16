// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        if(n<3)return n;
        int x1=1;
        int x2=2;
        int mod=1000000007;
        for(int i=3;i<=n;i++){
            int z=(x1%mod + x2%mod)%mod;
            x1=x2;
            x2=z;
            if(i==n)return z;
        }
       // return dp[n];
       return 0;
    }
}