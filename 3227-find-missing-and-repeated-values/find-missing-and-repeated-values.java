class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // Brute - 0(n^2) , Better = o(2*n) , sc = o(n) , optimal == o (n);
        long len = grid.length*grid.length;
        long expectedSum = (len * (len + 1)) / 2;
        long expectedSqSum = (len * (len + 1) * (2 * len + 1)) / 6;
        
        long actualSum = 0;
        long actualSqSum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
            actualSum += grid[i][j];
            actualSqSum += (long) grid[i][j] * grid[i][j];
            }
        }


        // Equation 1: X - Y = actualSum - expectedSum
        long diff = actualSum - expectedSum; 
        
        // Equation 2: X^2 - Y^2 = actualSqSum - expectedSqSum
        long sqDiff = actualSqSum - expectedSqSum; 
        
        // Find X + Y = (X^2 - Y^2) / (X - Y)
        long sum = sqDiff / diff; 
        
        // Solve for X (repeating) and Y (missing)
        // X = (diff + sum) / 2
        // Y = sum - X
        long repeating = (diff + sum) / 2;
        long missing = sum - repeating;
        
        return new int[]{(int) repeating, (int) missing};
    }
}