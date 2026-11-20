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
        if(root.left == null){
            return 1+f(root.right);
        }
        if(root.right == null) return 1+f(root.left);
        return f(root);
    }

    int f(TreeNode root) {
        if (root == null) return 0;

        int left = 1 + f(root.left);
        int right = 1 + f(root.right);

        return Math.max(left, right);
    }
}