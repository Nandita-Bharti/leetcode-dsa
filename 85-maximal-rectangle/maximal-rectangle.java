class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length , col = matrix[0].length;
        int[] height = new int[col];
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    height[j] += 1;
                }
                else{
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea , largestRectangleArea(height));

        }
        return maxArea;
    }

    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        nse[n-1] = n;   ///vvi (-1)
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();
            if(st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        while(st.size() > 0) st.pop();   //empty the stack and reuse it

        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);
        for(int i = 1; i < n; i++){
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();
            if(st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i<n; i++){
            int area = arr[i] * (nse[i] - pse[i] -1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
        }
}