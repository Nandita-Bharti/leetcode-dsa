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
 
 // BFS
 class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // If this is the FIRST node of the current level, 
                // it's visible from the left side!
                if (i == 0) {
                    result.add(curr.val);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }

        return result;
    }
}


 //we are not using bfs because the space complexity is high
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         view(root,0,ans);
//         return ans;
//     }
//     private void view(TreeNode root, int level,ArrayList<Integer> ans){
//         if(root == null) return;
//         if(level == ans.size()) ans.add(root.val);
//         view(root.right,level+1,ans);
//         view(root.left,level+1,ans);
//     }
// }


// DFS Approach
// class Solution {
//     public List<Integer> LeftSideView(TreeNode root) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         view(root,0,ans);
//         return ans;
//     }
//     private void view(TreeNode root, int level,ArrayList<Integer> ans ){
//         if(root == null) return;
//         if(level == ans.size()) ans.add(root.val);
//         view(root.left,level+1,ans);
//         view(root.right,level+1,ans);
//     }
// }