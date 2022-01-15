// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int n, int k)
    {
        // Write your code here
       // int count[]=new int[26];
        HashMap<Character,HashSet<Character>>graph=new HashMap<>();
        HashMap<Character,Integer>count=new HashMap<>();
        for(int i=0;i<n-1;i++)
        {
            String curr=dict[i];
            String next=dict[i+1];
            int len=Math.min(curr.length(),next.length());
            for(int j=0;j<curr.length();j++)
            {
                if(!count.containsKey(curr.charAt(j)))count.put(curr.charAt(j),0);
            }
            for(int j=0;j<next.length();j++)
            {
                if(!count.containsKey(next.charAt(j)))count.put(next.charAt(j),0);
            }
            
            for(int j=0;j<len;j++)
            {
                char ch1=curr.charAt(j);
                char ch2=curr.charAt(j);
                if(ch1!=ch2)
                {
                    if(graph.containsKey(ch1))
                    {
                         HashSet<Character>set=graph.get(ch1);
                              set.add(ch2);
                        graph.put(ch1,set); 
                    }
                    else
                    {
                        HashSet<Character>set=new HashSet<>();
                        set.add(ch2);
                        graph.put(ch1,set);
                    }
                    count.put(ch2,count.getOrDefault(ch2,0)+1);
                }
            }
        }
        Queue<Character>q=new LinkedList<>();
        
       for(char ch:count.keySet())
       {
           if(count.get(ch)==0)q.add(ch);
       }
       StringBuilder ans=new StringBuilder();
        while(q.size()>0)
        {
            char rem=q.remove();
            ans.append(rem);
            if(ans.length()==k)return ans.toString();
          if(graph.containsKey(rem))
          {
                for(char ch:graph.get(rem))
            {
                int x=count.get(ch);
                x=x-1;
                count.put(ch,x);
                if(count.get(ch)==0)q.add(ch);
            }
          }
            
        }
      //  System.out.println("jj");
        return ans.toString();
    }
}