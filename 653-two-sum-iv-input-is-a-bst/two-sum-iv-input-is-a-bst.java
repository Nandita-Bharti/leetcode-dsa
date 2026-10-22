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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) return false;

        // Check if complement exists
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);

        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}

// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         List<Integer> nums = new ArrayList<>();
//         inorder(root, nums);

//         int left = 0;
//         int right = nums.size() - 1;

//         while (left < right) {
//             int sum = nums.get(left) + nums.get(right);
//             if (sum == k) return true;
//             if (sum < k) left++;
//             else right--;
//         }

//         return false;
//     }

//     private void inorder(TreeNode node, List<Integer> list) {
//         if (node == null) return;
//         inorder(node.left, list);
//         list.add(node.val);
//         inorder(node.right, list);
//     }
// }