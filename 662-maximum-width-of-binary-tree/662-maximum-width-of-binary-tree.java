/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        root.val=0;
        help(root);
        int ans=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0)
        {
            int s=q.size();
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            while(s-->0)
            {
                TreeNode rem=q.remove();
                if(rem.left!=null)q.add(rem.left);
                if(rem.right!=null)q.add(rem.right);
                System.out.print(rem.val+" ");
                min=Math.min(min,rem.val);
                max=Math.max(max,rem.val);
            }
            System.out.println();
            ans=Math.max(ans,max-min+1);
            
        }
        return ans;
    }
    public static void help(TreeNode node)
    {
        
        if(node==null)return;
        if(node.left!=null)
        {
            node.left.val=2*node.val+1;
        }
        if(node.right!=null)
        {
            node.right.val=2*node.val+2;
        }
        help(node.left);
        help(node.right);
    }
}