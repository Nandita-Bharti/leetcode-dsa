class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        
        // 1. Find the Previous Smaller Element (PSE) index for each element
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // 2. Find the Next Less or Equal Element (NLE) index for each element
        int[] right = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // 3. Calculate total sum using contributions
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - left[i];     
            long rightCount = right[i] - i;     
            
            // Total subarrays where arr[i] is the minimum = leftCount * rightCount
            long contribution = (arr[i] * leftCount * rightCount) % mod;
            totalSum = (totalSum + contribution) % mod;
        }
        
        return (int) totalSum;
    }
}
// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         long sum = 0;
//         int min = Integer.MIN_VALUE;
//         int mod = (int)1e9+7;
//         for(int i = 0; i < n; i++){
//             min = arr[i];
//             for(int j = i; j < n; j++){
//                 min = Math.min(min,arr[j]);
//                 sum = (sum + min)%mod;
//             }
//         }
//         return (int)sum;
//     }
// }