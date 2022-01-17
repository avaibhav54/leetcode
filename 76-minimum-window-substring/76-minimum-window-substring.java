class Solution {
    public String minWindow(String s1, String s2) {
            HashMap<Character,Integer>map=new HashMap<>();
	    for(char ch:s2.toCharArray())
	    {
	        map.put(ch,map.getOrDefault(ch,0)+1);
	    }
	    HashMap<Character,Integer>map2=new HashMap<>();
	      int n2=s2.length();
	      int j=0;
	      int min=Integer.MAX_VALUE;
	      String ans="";
	      int count=0;
	      char arr[]=s1.toCharArray();
	      for(int i=0;i<arr.length;i++)
	      {
	          char ch=arr[i];
	          while(count>=n2)
	          {
	              char ch2=arr[j];
	              
	       if(map.containsKey(ch2))
	       {
	                   int x=map.get(ch2);
	          if(map2.getOrDefault(ch2,0)==x)
	          {
	              count--;
	          }
	       }
	            map2.put(ch2,map2.getOrDefault(ch2,0)-1);
	             if(i-j<min)
	              {
	                  min=i-j;
	                  ans=s1.substring(j,i);
	              }
	            j++;
	          }
	          
	         if(map.containsKey(ch))
	         {
	              int x=map.get(ch);
	          if(map2.getOrDefault(ch,0)<x)count++;
	          
	         }
	          map2.put(ch,map2.getOrDefault(ch,0)+1);
	          if(count==n2)
	          {
	               if(i-j+1<min)
	              {
	                  min=i-j+1;
	                  ans=s1.substring(j,i+1);
	              }
	          }
	          
	      }
	      int n=arr.length;
	         while(count>=n2)
	          {
	              char ch2=arr[j];
	              
	       if(map.containsKey(ch2))
	       {
	                   int x=map.get(ch2);
	          if(map2.getOrDefault(ch2,0)==x)
	          {
	              count--;
	          }
	       }
                 map2.put(ch2,map2.getOrDefault(ch2,0)-1);
	             if(n-j<min)
	              {
	                  min=n-j;
	                  ans=s1.substring(j,n);
	              }
	            j++;
	          }
	          
	      
	      return ans;
	      
	      
	      
    }
}