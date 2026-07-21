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
        return f(root, 1);
    }

    int f(TreeNode root, int count) {
        if (root == null) return count - 1;

        int left = f(root.left, count + 1);
        int right = f(root.right, count + 1);

        return Math.max(left, right);
    }
}