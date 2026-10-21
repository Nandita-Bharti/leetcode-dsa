/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr == null) {
                sb.append("null,");
                continue;
            }
            
            sb.append(curr.val).append(",");
            
            // Add left and right children, even if they are null
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        
        return sb.toString();
    }

    TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1; // Pointer for the values array
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            
            if (!values[i].equals("null")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                parent.left = leftChild;
                queue.offer(leftChild);
            }
            i++;
            
            if (!values[i].equals("null")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                parent.right = rightChild;
                queue.offer(rightChild);
            }
            i++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));