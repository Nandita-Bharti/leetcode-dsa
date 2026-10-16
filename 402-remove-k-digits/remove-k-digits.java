class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) return "0";        
        Stack<Character> stack = new Stack<>();

        // 1. Build a monotonic increasing stack
        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // 2. If k is still > 0 (e.g., num =  "12345" and k = 2), 
        // remove the remaining digits from the end (which are the largest)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse(); // Because stack is LIFO, reverse to get correct order
        
        //Remove leading zeros
        int startIndex = 0;
        while (startIndex < sb.length() && sb.charAt(startIndex) == '0') {
            startIndex++;
        }       
        String result = sb.substring(startIndex);
        return result.length() == 0 ? "0" : result;
    }
}