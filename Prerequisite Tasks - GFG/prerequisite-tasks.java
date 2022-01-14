// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<Integer> graph[]=new ArrayList[N];
        for(int i=0;i<N;i++)graph[i]=new ArrayList<>();
        int count[]=new int[N];
        for(int pair[]:prerequisites)
        {
            graph[pair[0]].add(pair[1]);
            count[pair[1]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            if(count[i]==0)q.add(i);
        }
        int countN=0;
        while(q.size()>0)
        {
            int x=q.remove();
            countN++;
            for(int it:graph[x])
            {
                count[it]--;
                if(count[it]==0)q.add(it);
            }
        }
        
        return countN==N;
    }
    
}