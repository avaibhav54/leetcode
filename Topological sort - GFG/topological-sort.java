// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/




class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int vtces, ArrayList<ArrayList<Integer>> adj) 
    {
        
        
boolean visited[]=new boolean[vtces];
Stack<Integer>st=new Stack<>();
for(int i=0;i<vtces;i++)
{
    if(visited[i]==false)
    {
        traverse(i,adj,visited,st);
    }
    
}
int ans[]=new int[st.size()];
    int i1=0;
    while(st.size()>0)
{
    ans[i1++]=st.pop();
}
return ans;
    }
    
    
   public static void traverse(int src,ArrayList<ArrayList<Integer>> graph,boolean visited[],Stack<Integer>st)
   {
       
       visited[src]=true;
       for(int  e:graph.get(src))
       {
           if(!visited[e])
           {
               traverse(e,graph,visited,st);
           }
       }
       st.push(src);
       
   }
}

