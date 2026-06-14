class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String sub = s.substring(i , j+1);
                if(isPalinedrome(sub) && sub.length() > ans.length()){
                    ans = sub;
                }
            }
        }
        return ans;
    }
    boolean isPalinedrome(String sub){
        int left = 0 , right = sub.length() - 1;
        while(left < right){
            if(sub.charAt(left++) != sub.charAt(right--)) return false;
        }
        return true;
    }
}