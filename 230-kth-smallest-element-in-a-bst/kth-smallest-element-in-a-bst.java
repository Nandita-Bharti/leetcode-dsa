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
    static int kth;
    static int ans;
    // this is the first approach 
    // public int kthSmallest(TreeNode root, int k) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     inorder(root,ans);
    //     return ans.get(k-1);
    
    // }
    // public void inorder(TreeNode root, ArrayList<Integer> ans){
    //     if(root == null) return;
    //     inorder(root.left,ans);
    //     ans.add(root.val);
    //     inorder(root.right,ans);

    // }

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        ans = -1;
        inorder(root,k);
        return ans;
    }
    public void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left,ans);
        kth--;
        if(kth == 0) ans = root.val;
        inorder(root.right,ans);

    }
}