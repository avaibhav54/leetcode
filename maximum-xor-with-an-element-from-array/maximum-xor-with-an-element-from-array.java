class Solution {
    
    public static class Node{
        Node child[];
        Node(){
            child=new Node[2];
        }
    }
    public static Node root;
    
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=queries.length;
        Arrays.sort(nums);
        int arr[][]=new int[n][3];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=queries[i][0];
            arr[i][1]=queries[i][1];        
            arr[i][2]=i;
        }
        int ans[]=new int[n];
                Arrays.sort(arr,(a,b)->a[1]-b[1]);
        root=new Node();
        int k=0;
        for(int i=0;i<n;i++)
        {
            while(k<nums.length && nums[k]<=arr[i][1])
            {
                insert(nums[k]);
                k++;
                
            }
            ans[arr[i][2]]=max(arr[i][0]);
            
        }
        return ans;

    }
}