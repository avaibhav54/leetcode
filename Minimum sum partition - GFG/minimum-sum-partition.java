// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

public boolean targetSumSubset(int arr[],int sum)
{
    int n=arr.length;
    boolean dp[][]=new boolean[n+1][sum+1];
    for(int i=0;i<=n;i++)
    
    {
        for(int j=0;j<=sum;j++)
        {
            if(j==0)dp[i][j]=true;
            else if(i==0)dp[i][j]=false;
            else
            {
                if(dp[i-1][j]==true)dp[i][j]=true;
                else
                {
                    int x=arr[i-1];
                    if(j>=x)
                    {
                        if(dp[i-1][j-x])dp[i][j]=true;
                    }
                }
            }
           // System.out.print(dp[i][j]+" ");
        }
        //System.out.println();
    }
    
    return dp[n][sum];
}
	public int minDifference(int arr[], int n) 
	{
	    int low=0;
	    int sum=0;
	    for(int x:arr)sum+=x;
	    int high=sum/2;
	    int ans=0;
	    for(int i=high;i>=0;i--)
	    {
	        if(targetSumSubset(arr,i))
	        {
	           // System.out.println(sum+" "+i);
	            return sum-2*i;
	        }
	    }
	   return ans;  
	} 
}
