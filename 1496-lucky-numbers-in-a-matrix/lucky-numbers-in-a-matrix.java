import java.util.ArrayList;
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            // Step 1: Find the minimum in the current row
            int minVal = matrix[i][0];
            int minColIndex = 0;
            
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minColIndex = j;
                }
            }
            
            // Step 2: Check if it's the maximum in its column
            boolean isLucky = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minColIndex] > minVal) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(minVal);
            }
        }
        
        return result;
    }
}