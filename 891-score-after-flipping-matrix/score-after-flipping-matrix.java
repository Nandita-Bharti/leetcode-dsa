class Solution {
    public int matrixScore(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //Step 1.  check row wise to find the first zero element row
        for(int i = 0; i < row ; i++){
            if(matrix[i][0] == 0){    
                //flip the entire row
                for(int j = 0; j < col; j++){
                    if(matrix[i][j] == 0) matrix[i][j] = 1;
                    else matrix[i][j] = 0;
                }
            }
        }

        // Step 2. Find those col with max no. of zeros and flip it
        for(int j = 0; j < col; j++){
            int zero = 0; 
            int ones = 0;
            for(int i = 0; i < row; i++){
                if(matrix[i][j] == 0) zero++;
                else ones++;
            }
            if(ones < zero){
                //flip the col
                for(int i = 0; i < row; i++){
                    if(matrix[i][j] == 0) matrix[i][j] = 1;
                    else matrix[i][j] = 0;
                }
            }
        }

        //Step 3. calculate total  sum row wise from backwards
        int sum = 0;
        for(int i = 0; i < row; i++){
            int x = 1;
            for(int j = col-1; j >=0; j--){
                sum += matrix[i][j]*x;
                x = x*2;

            }
        }
        return sum;
    }
}