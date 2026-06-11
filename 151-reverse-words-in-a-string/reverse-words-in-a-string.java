class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        // Step 1: Reverse the entire character array
        reverse(arr, 0, n - 1);
        
        // Step 2: Reverse each word back to normal
        reverseWordsInArray(arr, n);
        
        // Step 3: Clean up extra spaces in-place
        return cleanSpaces(arr, n);
    }
    
    // Helper function to reverse a segment of the array
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
    
    private void reverseWordsInArray(char[] arr, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || (i < n && arr[i] == ' ')) i++; // Find start of word
            while (j < i || (j < n && arr[j] != ' ')) j++; // Find end of word
            reverse(arr, i, j - 1); // Reverse the word
        }
    }
    
    private String cleanSpaces(char[] arr, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && arr[j] == ' ') j++;             // Skip spaces
            while (j < n && arr[j] != ' ') arr[i++] = arr[j++]; // Keep character
            while (j < n && arr[j] == ' ') j++;             // Skip spaces
            if (j < n) arr[i++] = ' ';                      // Keep only 1 space between words
        }
        return new String(arr, 0, i);
    }
}