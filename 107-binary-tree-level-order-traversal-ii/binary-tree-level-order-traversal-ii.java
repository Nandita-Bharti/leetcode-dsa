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
 class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node , int level){
        this.node = node;
        this.level = level;
    }
 }
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        if(root == null) return result;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0));
        int prevLevel = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode curr = p.node;
            int currLevel = p.level;

            if(currLevel != prevLevel){
                result.add(0 , new ArrayList<>(levelList));
                levelList.clear();
            }

            levelList.add(curr.val);
             if (curr.left != null)
                q.add(new Pair(curr.left, currLevel + 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, currLevel + 1));

            prevLevel = currLevel;
        }
        result.add(0 , new ArrayList<>(levelList));
        //Collections.reverse(result);

        return result;
    }
}