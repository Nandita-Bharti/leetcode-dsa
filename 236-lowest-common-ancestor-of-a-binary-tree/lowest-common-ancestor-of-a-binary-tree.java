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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
 }


// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null || root.val == p.val || root.val == q.val) return root;
//         boolean liesInLeft = exist(root.left , p);
//         boolean liesInRight = exist(root.right , q);
//         if(liesInLeft && liesInRight) return root;
//         if(!liesInLeft && !liesInRight) return root;
//         if(liesInLeft && !liesInRight) return lowestCommonAncestor(root.left , p , q);
//         return lowestCommonAncestor(root.right , p , q);
//     }
//     boolean exist(TreeNode root , TreeNode p){
//         if(root == null) return false;
//         if(root.val == p.val) return true;
        
//         return exist(root.left , p) || exist(root.right , p);
        
//     }
// }