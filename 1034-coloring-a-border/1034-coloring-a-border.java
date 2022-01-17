class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        dfs(grid,row,col,grid[row][col]);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]<0)grid[i][j]=color;
            }
        }
        return grid;
        
    }
    public static int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public static void dfs(int grid[][],int r,int c,int clr)
    {
        int count =0;
        grid[r][c]=-grid[r][c];
        for(int i=0;i<4;i++)
        {
            int rc=r+dir[i][0];
            int cc=c+dir[i][1];
            if(rc<0 || cc<0 || rc>=grid.length || cc>=grid[0].length || Math.abs(grid[rc][cc])!=clr)
            {continue;}
            if(grid[rc][cc]==clr)
            {
                dfs(grid,rc,cc,clr);
            }
                count++;
        }
        if(count ==4)grid[r][c]=Math.abs(grid[r][c]);
    }
}