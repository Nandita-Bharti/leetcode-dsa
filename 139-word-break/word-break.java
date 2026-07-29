class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int end = i + 1; end <= n; end++) {
                String prefix = s.substring(i, end);
                
                if (dict.contains(prefix) && dp[end]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}


// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {

//         Set<String> dict = new HashSet<>(wordDict);
//         boolean[] dp = new boolean[s.length()];
        
//         return f(0, s, dict, dp);
//     }
    
//     private boolean f(int i, String s, Set<String> dict, boolean[] dp) {

//         if (i == s.length()) {
//             return true;
//         }

//         if (dp[i] != false) {
//             return dp[i];
//         }

//         for (int end = i + 1; end <= s.length(); end++) {

//             String prefix = s.substring(i, end);

//             if (dict.contains(prefix) && f(end, s, dict, dp)) {

//                 dp[i] = true;
//                 return true;
//             }
//         }

//         dp[i] = false;
//         return false;
//     }
// }