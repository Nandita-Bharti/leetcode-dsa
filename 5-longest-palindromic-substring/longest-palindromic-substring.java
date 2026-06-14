class Solution {
    public String longestPalindrome(String s) {
    //Brute - TC -> O(N^3)
    //     int n = s.length();
    //     String ans = "";
    //     for(int i = 0; i < n; i++){
    //         for(int j = i; j < n; j++){
    //             String sub = s.substring(i , j+1);
    //             if(isPalinedrome(sub) && sub.length() > ans.length()){
    //                 ans = sub;
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // boolean isPalinedrome(String sub){
    //     int left = 0 , right = sub.length() - 1;
    //     while(left < right){
    //         if(sub.charAt(left++) != sub.charAt(right--)) return false;
    //     }
    //     return true;
    // }
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;  
        
        for (int i = 0; i < s.length(); i++) {
            
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  
            right++; 
        }
    
        return right - left - 1;
    }
}
