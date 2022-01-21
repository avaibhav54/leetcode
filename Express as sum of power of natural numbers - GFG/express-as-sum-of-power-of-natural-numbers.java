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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int numOfWays(int n, int x)
    {
        // code here
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp)Arrays.fill(row,-1);
        return help(n,x,1,dp);
    }
    public static int help(int n,int x,int c,int[][] dp)
    {
        if(dp[n][c]!=-1)return dp[n][c];
        if(Math.pow(c,x)>n)
        {
            return dp[n][c]=0;
        }
        else  if(Math.pow(c,x)==n)
        {
            return dp[n][c]=1;
        }
        return dp[n][c]=(help(n-(int)Math.pow(c,x),x,c+1,dp)+help(n,x,c+1,dp))%1000000007;
        
    }
}