class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length , col = mat[0].length;
        int low = 0 , high = col-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            int maxRowIdx = findMax(mid , mat ,row);
            int left = mid-1 >= 0? mat[maxRowIdx][mid-1] : -1;
            int right = mid+1 < col? mat[maxRowIdx][mid+1] : -1;
            if(mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right) return new int[]{maxRowIdx,mid};
            else if(mat[maxRowIdx][mid] < left) high = mid-1;
            else low = mid+1;
        }
        return new int[]{-1,-1};
    }
    int findMax(int mid , int[][] mat , int row){
        int max = -1 , idx = -1;
        for(int i = 0; i < row; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }
}