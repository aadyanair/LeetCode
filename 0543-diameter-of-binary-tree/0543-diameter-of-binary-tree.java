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
    int d =0;
    public int maxDepth(TreeNode root){
        if(root==null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        d = Math.max(d,lh+rh);

        return Math.max(lh,rh)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return d;
    }
}