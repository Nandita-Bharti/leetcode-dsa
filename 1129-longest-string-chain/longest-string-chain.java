class Solution {
    boolean check(String s1 , String s2){
        if(s1.length() != s2.length()+1) return false;
        int i = 0 , j = 0;
        while(i < s1.length()){
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;j++;
            }
            else{
                i++;
            }
        }
        return j == s2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length , maxi = 1;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(check(words[i] , words[prev]) && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                } 
            }
            maxi = Math.max(maxi , dp[i]);
        }
        return maxi;
    }
}