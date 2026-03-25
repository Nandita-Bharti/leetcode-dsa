class Solution {
    public void transposeInPlace(int[][] matrix, int r, int c){
        // only valid for square matrix
        for(int i=0;i<r-1;i++){
            for(int j=i+1;j<c;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void reverseArray(int[] matrix){
        int i =0;
        int j = matrix.length-1;
        while(i<j){
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // first find transpose
        transposeInPlace(matrix,n,n);
        // then reverse each row
        for(int i=0;i<n;i++){
            reverseArray(matrix[i]);
        }
    }
}