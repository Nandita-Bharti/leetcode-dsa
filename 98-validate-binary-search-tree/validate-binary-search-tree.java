class Solution {
    class Pair {
        long max;
        long min;
        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        boolean[] isBST = new boolean[]{true};
        maxMin(root, isBST);
        return isBST[0];
    }

    private Pair maxMin(TreeNode root, boolean[] isBST) {
        if (root == null) {
            return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        Pair lst = maxMin(root.left, isBST);
        Pair rst = maxMin(root.right, isBST);

        long data = (long) root.val;

        long max = Math.max(data, Math.max(lst.max, rst.max));
        long min = Math.min(data, Math.min(lst.min, rst.min));

        if (lst.max >= data || rst.min <= data) {
            isBST[0] = false;
        }

        return new Pair(max, min);
    }
}