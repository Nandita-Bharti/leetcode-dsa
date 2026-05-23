class Solution {
    
    public int countNegatives(int[][] grid) {
    //     int count = 0;
    //     for(int i = 0; i<grid.length; i++){
    //         for(int j = 0; j<grid[i].length;j++){
    //             if(grid[i][j] < 0) count++;
    //         }
    //     }
    //     return count;
    int row = grid.length;
    int col = grid[0].length;
    int neg = 0;
    for(int i = 0 ; i < row ; i++){
        int lo = 0 , high = col-1;
        while(lo <= high){
            int mid = (lo+high)/2;
            if(grid[i][mid] < 0) high = mid-1;
            else lo = mid+1;
        }
        neg += col - lo;
    }
    return neg;
    }
}