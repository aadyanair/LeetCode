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
    List<int[]> nodeList = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);


        Collections.sort(nodeList,(a,b) ->{
            if(a[0] != b[0]) return a[0]-b[0]; // sort by col
            else if(a[1] != b[1])return a[1]-b[1]; //sort by row
            else return a[2]-b[2]; //sort by val
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for(int[] entry : nodeList){
            int col = entry[0], val = entry[2];
            if(col != prevCol){
                res.add(new ArrayList<>());
                prevCol = col;
            }
            res.get(res.size()-1).add(val);
        }
        return res;
    }

    public void dfs(TreeNode node, int row, int col){
        if(node==null) return;
        nodeList.add(new int[]{col,row,node.val});
        dfs(node.left,row+1,col-1);
        dfs(node.right,row+1,col+1);
    }
}