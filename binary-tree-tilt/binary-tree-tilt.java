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
    public int findTilt(TreeNode root) {
        ans=0;
        help(root);
        return ans;
    }
    public static void help(TreeNode node)
    {
    
        if(node==null)return;
        ans+=Math.abs(sum(node.left)-sum(node.right));
        help(node.left);
        help(node.right);
    }
    public static int sum(TreeNode node)
    {
        if(node==null)return 0;
        return sum(node.left)+sum(node.right)+node.val;
    }
}