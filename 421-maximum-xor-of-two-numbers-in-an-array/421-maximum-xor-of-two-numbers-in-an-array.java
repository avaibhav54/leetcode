class Solution {
    public static class Node
    {
        Node child[];
        Node(){
            child=new Node[2];
        }
    }
    public static Node root;
    public int findMaximumXOR(int[] nums) {
 int ans=0;
root=new Node();

for(int x:nums)
{
    insert(x);
}
for(int x:nums)
{
  
    ans=Math.max(ans,max(x));
}
        

    return ans;
    }
    
    
public static int max(int num)
    {
        Node curr=root;
       // insert(0);
        int ans=0;
        try{
        for(int i=31;i>=0;i--)
        {
            int bit = (num >> i) & 1; 
           // System.out.println(bit+" "+num);
            if(curr.child[1-bit]!=null)
            {
                ans=ans|(1<<i);
                curr=curr.child[1-bit];
            }
            else{
                curr=curr.child[bit];
            }
        }
        
        return ans;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
       public static void insert(int num)
    {
        Node curr=root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num >> i) & 1; 
            if(curr.child[bit]==null)
            {
                curr.child[bit]=new Node();
            }
            curr=curr.child[bit];
        }
    }
}

