/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node>queue=new LinkedList<>();
        if(root==null)return null;
        queue.add(root);
        
        while(queue.size()>0)
        {
            int x=queue.size();
            Node prev=null;
            while(x-->0)
            {
                Node r=queue.remove();
                
                if(r.left!=null)
                {
                    queue.add(r.left);
                }
                if(r.right!=null)
                {
                    queue.add(r.right);
                }
                
                if(prev!=null)
                {
                    prev.next=r;
                }
                    prev=r;
            }
            
            
        }
       return root; 
    }
}