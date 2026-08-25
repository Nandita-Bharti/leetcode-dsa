class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[] ans = new int[n * m];

        int row = 0;
        int col = 0;

        // 1 = UP-RIGHT
        // 0 = DOWN-LEFT
        int direction = 1;

        for (int i = 0; i < n * m; i++) {

            ans[i] = mat[row][col];

            if (direction == 1) {

                if (col == m - 1) {
                    // right boundary
                    row++;
                    direction = 0;
                }
                else if (row == 0) {
                    // top boundary
                    col++;
                    direction = 0;
                }
                else {
                    row--;
                    col++;
                }

            } else {

                if (row == n - 1) {
                    // bottom boundary
                    col++;
                    direction = 1;
                }
                else if (col == 0) {
                    row++;
                    direction = 1;
                }
                else {
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }
}