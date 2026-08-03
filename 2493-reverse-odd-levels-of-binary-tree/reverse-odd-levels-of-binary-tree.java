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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        f(root.left , root.right , 1);
        return root;
    }
    void f(TreeNode node1 , TreeNode node2 , int level){
        if(node1 == null || node2 == null) return;
        if(level % 2 == 1){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        }


        f(node1.left , node2.right , level+1);
        f(node1.right, node2.left, level + 1);

    }
}