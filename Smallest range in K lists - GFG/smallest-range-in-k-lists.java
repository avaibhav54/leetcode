// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}
// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] nums,int k,int n)
	{
      int ans[]={-100000,100000};
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.elem-b.elem);
        int len=200000;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int ele=nums[i][0];
            max=Math.max(max,ele);
            pq.add(new Pair(ele,i,0));
        }
        while(true)
        {
            Pair rem=pq.remove();
            if(ans[1]-ans[0]>max-rem.elem)
            {
                ans[0]=rem.elem;
                ans[1]=max;
            }
           
            if(rem.j==k-1)break;
            int elem=nums[rem.i][rem.j+1];
            pq.add(new Pair(elem,rem.i,rem.j+1));
            max=Math.max(max,elem);
        }
        
        return ans;
	}
	  public static class Pair
    {
        int elem;
        int i;
        int j;
        Pair(int elem,int i,int j)
        {
            this.elem=elem;
            this.i=i;
            this.j=j;
        }
    }
}