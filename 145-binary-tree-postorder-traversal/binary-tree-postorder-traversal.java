class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st1 = new Stack<>();
        st1.push(root);
        Stack<TreeNode> st2 = new Stack<>();
        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
            st2.push(curr);
            if(curr.left!=null) st1.push(curr.left);
            if(curr.right!=null) st1.push(curr.right);
        }
        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }
        return ans;
    }
}
// class Solution {
//      public void dfs(TreeNode root, List<Integer> ans){
//         if(root == null) return;
//         dfs(root.left, ans);
//         dfs(root.right, ans);
//         ans.add(root.val);
//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         dfs(root,ans);
//         return ans;
//     }
// }