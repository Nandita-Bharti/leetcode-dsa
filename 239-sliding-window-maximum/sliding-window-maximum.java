class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];       
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;
        
        // Deque to store indices of elements, maintained in decreasing order of values
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Remove elements from the back that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Push current index to the back
            deque.offerLast(i);
            
            // 4. If the window has reached size k, record the max (front of deque)
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }        
        return result;
    }
}

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if (n == 0 || k == 0) return new int[0];       
//         int[] result = new int[n - k + 1];
//         for (int i = 0; i <= n - k; i++) {
//             int max = nums[i];
//             for (int j = i; j < i + k; j++) {
//                 max = Math.max(max, nums[j]);
//             }
//             result[i] = max;
//         }       
//         return result;
//     }
// }