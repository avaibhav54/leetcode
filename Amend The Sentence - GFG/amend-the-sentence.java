// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
        //code here
        char arr[]=s.toCharArray();
        arr[0]=Character.toLowerCase(arr[0]);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
           char ch=arr[i];
           if(Character.isLowerCase(ch))ans.append(ch);
           else
           {
               ans.append(' ');
               ans.append(Character.toLowerCase(ch));
           }
        }
        return ans.toString();
    }
}

