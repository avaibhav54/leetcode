// { Driver Code Starts
import java.util.*;
import java.lang.Math;
class Pots{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] a =new  int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			GfG g = new GfG();
			System.out.println(g.maxCoins(a,n));
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public static int maxCoins(int A[],int n)
	{
      
      int dp[][]=new int[n][n];
      for(int g=0;g<n;g++)
      {
          for(int i=0,j=g;j<n;i++,j++)
          {
              if(i==j)
              {
                  dp[i][j]=A[i];
              }
              else if(j-i==1)
              {
                 dp[i][j]=Math.max(A[i],A[j]); 
              }
              else
              {
                  //System.out.println(i+" "+j);
                  dp[i][j]=Math.max(A[i]+Math.min(dp[i+1][j-1],dp[i+2][j]),A[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
              }
          }
          
      }
      return dp[0][n-1];
    }
}