class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // memo[i] stores the minimum partitions for substring s[i...n-1]
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        // isPal[i][j] caches whether substring s[i...j] is a palindrome
        Boolean[][] isPal = new Boolean[n][n];
        
        // solve() returns partitions. Number of cuts = partitions - 1
        return solve(0, s, memo, isPal) - 1;
    }
    
    private int solve(int i, String s, int[] memo, Boolean[][] isPal) {
        // Base case: If we reached the end of the string, it requires 0 partitions
        if (i == s.length()) return 0;
        
        // Return cached result if already calculated
        if (memo[i] != -1) return memo[i];
        
        int minPartitions = Integer.MAX_VALUE;
        
        // Try making a cut at every j from i to the end
        for (int j = i; j < s.length(); j++) {
            
            // Only branch out if the left piece (i to j) is a valid palindrome
            if (isPalindrome(s, i, j, isPal)) {
                int partitions = 1 + solve(j + 1, s, memo, isPal);
                minPartitions = Math.min(minPartitions, partitions);
            }
        }
        
        return memo[i] = minPartitions;
    }
    
    // Helper function to check palindromes (also memoized to prevent TLE)
    private boolean isPalindrome(String s, int i, int j, Boolean[][] isPal) {
        if (i >= j) return true;
        
        if (isPal[i][j] != null) return isPal[i][j];
        
        if (s.charAt(i) == s.charAt(j)) {
            return isPal[i][j] = isPalindrome(s, i + 1, j - 1, isPal);
        }
        
        return isPal[i][j] = false;
    }
}