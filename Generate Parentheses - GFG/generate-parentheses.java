// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static List<String>ans;
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        ans=new ArrayList();
        help(n,0,0,"");
        return ans;
    }
    public static void help(int m,int cs,int ce,String str)
    {
        if(cs==m && ce==m)
        {
            ans.add(str);
            return;
        }
        else if(cs==m)
        {
            help(m,cs,ce+1,str+")");
        }
        else if(cs==ce)
        {
              help(m,cs+1,ce,str+"(");

        }
        else 
        {
            help(m,cs+1,ce,str+"(");
            help(m,cs,ce+1,str+")");
            
        }
    }
}