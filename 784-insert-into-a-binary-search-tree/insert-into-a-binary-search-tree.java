class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
       if(root == null){
        TreeNode a = new TreeNode(val);
        return a;
       }
       insert(root,val);
       return root;
    }
    public void insert(TreeNode root, int val){
        if(root == null) return;
        if(root.val == val) return;
        if(root.val > val){
            if(root.left == null) root.left = new TreeNode(val);
            else insert(root.left,val);
        } 
        else{
            if(root.right == null) root.right = new TreeNode(val);
            else insert(root.right,val);
        }
    }
}