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
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
     public static class Node
    {
        Node child[];
        boolean isEnd;
        Node(){
            child=new Node[26];
            
        }
    }
    public static Node root;
    public static void insert(String str)
    {
        Node curr=root;
        for(char ch:str.toCharArray())
        {
            if(curr.child[ch-'a']==null)
            {
                curr.child[ch-'a']=new Node();
            }
            curr=curr.child[ch-'a'];
        }
        curr.isEnd=true;
    }
    public static  void wordsStartsWithHelper(Node node,List<String>l,StringBuilder str) {   
           
        if(node==null)return;
        if(node.isEnd==true)
        {
            l.add(str.toString());
        }
           for(int i=0;i<26;i++){
              if(node.child[i]!=null){ 
                 
                 
                 }
                  
                  wordsStartsWithHelper(node.child[i],l,str.append((char)('a'+i)));
               str.deleteCharAt(str.length()-1);
              }
          }
        
    public static ArrayList<String> startsWith(String str)
    {
        ArrayList<String>temp=new ArrayList<>();
        Node curr=root;
        for(char ch:str.toCharArray())
        {
            if(curr.child[ch-'a']==null)return temp;
            curr=curr.child[ch-'a'];
        }
        
        wordsStartsWithHelper(curr,temp,new StringBuilder(str));
        
        return temp;
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
       ArrayList<ArrayList<String>>ans=new ArrayList<>();
        root=new Node();
        for(String str:contact)
        {
            insert(str);
        }
        for(int i=1;i<=s.length();i++)
        {
            String str=s.substring(0,i);
          //  System.out.println(str);
            ArrayList<String>temp=startsWith(str);
           // System.out.println(temp.size());
            if(temp.size()==0)
            {
                temp.add("0");
                ans.add(temp);
            }
            else
            ans.add(temp);
        }
        return ans;
    }
}