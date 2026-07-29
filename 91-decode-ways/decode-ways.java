class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base Case mapping: if(i == s.length()) return 1;
        dp[n] = 1;
        
        // Build the table backwards from right to left
        for (int i = n - 1; i >= 0; i--) {
 
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } 
            else {
                int ways = dp[i + 1];

                if (i + 1 < n) {
                    int lastTwoDigit = Integer.parseInt(s.substring(i , i+2));
                    if(lastTwoDigit >= 10 && lastTwoDigit <= 26){
                        ways += dp[i + 2];
                    }
                }
                dp[i] = ways;
            }
        }

        return dp[0];
    }
}

// class Solution {
//     public int numDecodings(String s) {
//         int[] dp = new int[s.length() + 1];
//         Arrays.fill(dp , -1);
//         return f(0 , s , dp);
//     }

//     int f(int i , String s , int[] dp){

//         if(i == s.length()) return 1;
//         if(s.charAt(i) == '0') return 0;

//         if(dp[i] != -1) return dp[i];
//         int ways = f(i+1 , s , dp);
//         if(i+1 < s.length()){
//             int lastTwoDigit = Integer.parseInt(s.substring(i , i+2));
//             if(lastTwoDigit >= 10 && lastTwoDigit <= 26){
//                 ways += f(i+2 , s , dp);
//             }
//         }
//         return dp[i] = ways;
//     }
// }