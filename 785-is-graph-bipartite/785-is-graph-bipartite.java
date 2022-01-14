class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!bipart(graph,color,i))return false;
            }
        }
        return true;
    }
    public static boolean bipart(int graph[][],int color[],int src)
    {
        
     
        for(int x:graph[src])
        {
            if(color[x]==-1)
            {
             //   System.out.println(color[src]);
                color[x]=1-color[src];
                if(!bipart(graph,color,x))return false;
            }
            else if(color[x]==color[src])
            {
                return false;
            }
        }
        return true;
    }
}