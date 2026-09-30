class Solution {
    public int countKeyChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));
            char prev = Character.toLowerCase(s.charAt(i - 1));
            if (curr != prev) {
                ans++;
            }
        }
        
        return ans;
    }
}