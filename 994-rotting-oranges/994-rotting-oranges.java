class Solution {
    public int orangesRotting(int[][] grid) {
        int ans=0;
        Queue<Pair>que=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    que.add(new Pair(i,j));
                }
                    
            }
        }
        
        while(que.size()>0)
        {
            boolean f=false;
            int x=que.size();
            int arr[][]={{0,1},{1,0},{-1,0},{0,-1}};
            while(x-->0)
            {
                Pair r=que.remove();
                for(int k=0;k<4;k++)
                {
                    int nr=r.indi+arr[k][0];
                    int nc=r.indj+arr[k][1];
                    if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc]!=1)continue;
                    f=true;
                    grid[nr][nc]=2;
                    que.add(new Pair(nr,nc));
                }
                
            }
            if(f)ans++;
            
            
        }
           for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
                    
            }
        }
        return ans;
        
    }
    public class Pair{
        int indi;
        int indj;
        Pair(int indi,int indj)
        {
            this.indi=indi;
            this.indj=indj;
        }
    }
}