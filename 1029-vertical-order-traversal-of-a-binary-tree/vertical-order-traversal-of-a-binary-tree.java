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
class Tuple {
    TreeNode node;
    int x; // Vertical Column
    int y; // Depth Level
        
    public Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map structure: Map<X, Map<Y, PriorityQueue<Values>>>
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            Tuple curr = queue.poll();
            TreeNode node = curr.node;
            int x = curr.x;
            int y = curr.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            
            // Add the node's value to the priority queue at this (X, Y)
            map.get(x).get(y).offer(node.val);
            
            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodesAtSamePos : yMap.values()) {
                while (!nodesAtSamePos.isEmpty()) {
                    column.add(nodesAtSamePos.poll());
                }
            }
            result.add(column);
        }
        
        return result;
    }
}