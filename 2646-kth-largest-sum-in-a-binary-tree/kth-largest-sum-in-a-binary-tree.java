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
    class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));

        List<Long> levelList = new ArrayList<>();
        int prevLevel = 0;
        long sum = 0;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode currNode = p.node;
            int currLevel = p.level;

            if(currLevel != prevLevel){
                levelList.add(sum);
                sum = 0;
            }
            sum += currNode.val;

            if (currNode.left != null)
                queue.add(new Pair(currNode.left, currLevel + 1));
            if (currNode.right != null)
                queue.add(new Pair(currNode.right, currLevel + 1));

            prevLevel = currLevel;
        }
        levelList.add(sum);
        if (levelList.size() < k) {
            return -1;
        }
        Collections.sort(levelList);
        return levelList.get(levelList.size()-k);

    }
}