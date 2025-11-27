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
    int d = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return d;
    }

    public int maxSum(TreeNode root){
        if(root==null) return 0;
        int lh = maxSum(root.left);
        int rh = maxSum(root.right);

        d = Math.max(d,root.val + Math.max(0,lh) + Math.max(0,rh));

        return root.val + Math.max(0,Math.max(lh,rh));
    }
}