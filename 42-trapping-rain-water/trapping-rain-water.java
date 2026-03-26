class Solution {
    public int trap(int[] height) {
        int n = height.length;
        //find prev greater array
        int[] prev = new int[n];
        prev[0] = -1;
        int max = height[0];
        for(int i = 1; i < n; i++){
            prev[i] = max;
            if(max < height[i]) max = height[i];
        }
        //find next greater array using prev and keeping the minimun element in mid
        prev[n-1] = -1;
        max = height[n-1];
        for(int i = n-2; i >= 0; i--){
            if(max < prev[i]) prev[i] = max;
            if(max < height[i]) max = height[i];
        }
        //calculate the water
        int water = 0;
        for(int i = 1; i < n-1; i++){
            if(height[i] < prev[i]){
                water += prev[i] - height[i];
            }
        }
        return water;
    }
}