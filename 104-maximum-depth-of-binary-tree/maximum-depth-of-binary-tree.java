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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // If either child is null, one of left/right is 0.
        // The path must go through the non-null child (so take the larger one).
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        // Both children exist, so take the shorter path to a leaf
        return Math.max(left, right) + 1;
    }
}
