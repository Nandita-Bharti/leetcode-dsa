class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(m, n, s, p, dp);
    }
    boolean f(int i, int j, String s, String p, int[][] dp) {
        if(i == 0 && j == 0) return true;
        if(j == 0 && i > 0) return false;
        if(i == 0 && j > 0) {
            for(int k = 1; k <= j; k++) {
                if(p.charAt(k - 1) != '*')
                    return false;
            }
            return true;
        }
        if(dp[i][j] != -1)
            return dp[i][j] == 1;
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            boolean ans = f(i - 1, j - 1, s, p, dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        if(p.charAt(j - 1) == '*') {
            boolean ans = f(i - 1, j, s, p, dp) || f(i, j - 1, s, p, dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        dp[i][j] = 0;
        return false;
    }
}


// class Solution {
//     public boolean isMatch(String s, String p) {
//         int m = s.length(), n = p.length();
//         return f(m, n, s, p);
//     }
//     boolean f(int i, int j, String s, String p) {
//         if(i == 0 && j == 0) return true;
//         if(j == 0 && i > 0) return false;
//         if(i == 0 && j > 0) {
//             for(int k = 1; k <= j; k++) {
//                 if(p.charAt(k - 1) != '*')
//                     return false;
//             }
//             return true;
//         }
//         if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
//             return f(i - 1, j - 1, s, p);
//         }
//         if(p.charAt(j - 1) == '*') {
//             return f(i - 1, j, s, p) || f(i, j - 1, s, p);
//         }
//         return false;
//     }
// }