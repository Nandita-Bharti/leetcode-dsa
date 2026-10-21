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
        int index;
        
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0)); // Start root at index 0
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Get the index of the first node on this level to normalize indices
            int minIndex = queue.peek().index; 
            
            int firstIdx = 0;
            int lastIdx = 0;
            
            for (int i = 0; i < levelSize; i++) {
                Pair cur = queue.poll();
                TreeNode node = cur.node;
                
                // Normalize index to prevent integer overflow
                int normalIdx = cur.index - minIndex;
                
                // Track the first and last elements of the level
                if (i == 0) firstIdx = normalIdx;
                if (i == levelSize - 1) lastIdx = normalIdx;
                
                // Push left child with index: 2 * i
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * normalIdx));
                }
                // Push right child with index: 2 * i + 1
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * normalIdx + 1));
                }
            }
            
            // Calculate width for this level and update max
            int curWidth = lastIdx - firstIdx + 1;
            maxWidth = Math.max(maxWidth, curWidth);
        }
        
        return maxWidth;
    }
}