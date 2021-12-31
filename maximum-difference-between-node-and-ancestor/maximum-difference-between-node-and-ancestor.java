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
    public static int ans;
    public int maxAncestorDiff(TreeNode root) {
        ans=0;
        help(root);
        help2(root);
        return ans;
    }
    public int help(TreeNode node)
    {
        if(node==null)return Integer.MAX_VALUE;
        int x=help(node.left);
        int y=help(node.right);
        int z=Math.min(x,y);
        ans=Math.max(ans,node.val-z);
        return Math.min(node.val,z);
    }    public int help2(TreeNode node)
    {
        if(node==null)return Integer.MIN_VALUE;
        int x=help2(node.left);
        int y=help2(node.right);
        int z=Math.max(x,y);
        if(z!=Integer.MIN_VALUE)
        ans=Math.max(ans,z-node.val);
        return Math.max(node.val,z);
    }
}