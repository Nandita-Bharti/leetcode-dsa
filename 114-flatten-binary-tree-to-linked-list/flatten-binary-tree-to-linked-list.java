class Solution {
    public void flatten(TreeNode root) {
    TreeNode curr = root;
    while(curr != null){
        if(curr.left != null){  //find pred
            TreeNode pred = curr.left;
            while(pred.right !=null) pred = pred.right;
            pred.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
            curr = curr.right;    
        }
        else curr = curr.right;
    }
    //     first method by using preorder array
    //     ArrayList<TreeNode> arr = new ArrayList<>();
    //     dfs(root,arr);
    //     for(int i = 0; i<arr.size()-1; i++){
    //         TreeNode a = arr.get(i);
    //         TreeNode b = arr.get(i+1);
    //         a.right = b;
    //         a.left = null;
    //     }
    //     if(arr.size() > 1){
    //     TreeNode last = arr.get(arr.size() - 1);
    //     last.left = null;
    //     last.right = null;
    //     }
    // }
    // private static void dfs(TreeNode root,  ArrayList<TreeNode> arr){
    //     if(root == null) return;
    //     arr.add(root);
    //     dfs(root.left,arr);
    //     dfs(root.right,arr);

    
// recursive method 
//      public TreeNode flat(TreeNode root){
//         if(root == null) return null;
//         root.left = flat(root.left);
//         root.right = flat(root.right);

    }
}