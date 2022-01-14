// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int test= help(grid,i,j);
                    ans=Math.max(ans,test);
                }
            }
        }
        return ans;
    }
    public static int  help(int grid[][],int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)return 0;
      grid[i][j]=0;
      int x= help(grid,i+1,j);
      int x2= help(grid,i,j+1);
      int x3= help(grid,i-1,j);
      int x4= help(grid,i,j-1);
      int x5= help(grid,i+1,j-1);
      int x6= help(grid,i-1,j-1);
      int x7= help(grid,i+1,j+1);
      int x8= help(grid,i-1,j+1);
      
       return 1+x+x2+x3+x4+x5+x6+x7+x8;
       
    }
}