// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	if(str.charAt(0)!='-'){
	   return help(str);
    
    }
    else 
    {
        String str2=str.substring(1);
        return help(str2)*(-1);
    }
    }
    public static int help(String str)
    {
        for(char ch:str.toCharArray())
	   {
	       if(!Character.isDigit(ch))return -1;
	   }
	   int ans=0;
	   for(char ch:str.toCharArray())
	   {
	       ans=ans*10+Character.getNumericValue(ch);
	   }
	   return ans;
    }
}
