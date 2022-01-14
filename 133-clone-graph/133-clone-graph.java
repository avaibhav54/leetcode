/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public static void dfs(Node node,Node ans,Node[] visited)
    {
        visited[ans.val]=ans;
     
        for(Node n:node.neighbors)
        {
            if(visited[n.val]==null)
        {
                Node ne=new Node(n.val);
                ans.neighbors.add(ne);
            dfs(n,ne,visited);
        }
         else
         {
                ans.neighbors.add(visited[n.val]);
         }
         
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Node ans=new Node(node.val);
      dfs(node,ans,new Node[1000]);
        return ans;
    }
}