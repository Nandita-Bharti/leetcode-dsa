class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return ans;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){

            while(curr != null){
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return ans;
    }
}

// class Solution {
//     public void dfs(TreeNode root, List<Integer> ans){
//         if(root == null) return;
//         ans.add(root.val);
//         dfs(root.left, ans);
//         dfs(root.right, ans);
//     }
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         dfs(root,ans);
//         return ans;
//     }
// }