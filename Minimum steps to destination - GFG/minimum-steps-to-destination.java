// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int x){
       int i=1;
        int temp=0;
        while(temp<x)
        {
            temp+=i;
            i++;
        }
        int dis=temp-x;
        if(dis%2==0)
        {return i-1;
            
        }
        else if((dis+i)%2==0)
        {
            return i;
        }
        else
        {
            return i+1;
        }
    }
}