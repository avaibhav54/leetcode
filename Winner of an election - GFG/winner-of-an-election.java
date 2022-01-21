// { Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer>map=new HashMap<>();
        for(String str:arr)
        {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        String ans[]=new String[2];
        int max=0;
        for(String str:map.keySet())
        {
            if(map.get(str)>max)
            {
                max=map.get(str);
                ans[0]=str;
                ans[1]=""+max;
            }
            else if(map.get(str)==max)
            {
                String st1=ans[0];
                if(st1.compareTo(str)>0)
                {
                    max=map.get(str);
                ans[0]=str;
                ans[1]=""+max;
                }
            }
        }
        return ans;
    }
}

