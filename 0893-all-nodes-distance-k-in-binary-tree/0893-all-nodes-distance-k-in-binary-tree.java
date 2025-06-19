/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        markParents(root,null,parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);


        int currentLevel = 0;

        while(!q.isEmpty()){

            if(currentLevel==k) break;

            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left!=null &&  !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }

                TreeNode parent = parentMap.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.offer(parent);
                    visited.add(parent);
                }

            }

            currentLevel++;
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }

    public void markParents(TreeNode node,TreeNode parent, Map<TreeNode,TreeNode> parentMap){
        if(node==null) return;

        if(parent!=null){
            parentMap.put(node,parent);
        }

        markParents(node.left,node,parentMap);
        markParents(node.right,node,parentMap);
    }
}