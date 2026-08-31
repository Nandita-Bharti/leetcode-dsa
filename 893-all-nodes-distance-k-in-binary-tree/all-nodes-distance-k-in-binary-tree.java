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
    void buildParent(Map<TreeNode , TreeNode> parent , TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null){
                parent.put(cur.left , cur);
                q.offer(cur.left);
            }
            if(cur.right != null){
                parent.put(cur.right , cur);
                q.offer(cur.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        buildParent(parent , root);
        Map<TreeNode , Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target , true);
        int level = 0;
        while(!q.isEmpty()){
            if(level == k) break;
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();

                if(cur.left != null && visited.get(cur.left) == null){
                    q.offer(cur.left);
                    visited.put(cur.left , true);
                }

                if(cur.right != null && visited.get(cur.right) == null){
                    q.offer(cur.right);
                    visited.put(cur.right , true);
                }

                if(parent.get(cur) != null && visited.get(parent.get(cur)) == null){
                    q.offer(parent.get(cur));
                    visited.put(parent.get(cur) , true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            ans.add(cur.val);
        }

        return ans;
    }
}