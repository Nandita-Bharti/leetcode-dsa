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
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        f(root , maxi);
        return maxi[0];
    }
    int f(TreeNode root , int[] maxi){
        if(root == null) return 0;
        int leftSum = Math.max(0, f(root.left, maxi));
        int rightSum = Math.max(0, f(root.right, maxi));
        maxi[0] = Math.max(maxi[0] , root.val+leftSum+rightSum);
        return root.val + Math.max(leftSum , rightSum);
    }
}