class Solution {
    //Brute - TC->O(N^2) , SC -> O(N)
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            // Check if current state matches goal
            if (sb.toString().equals(goal)) {
                return true;
            }
            
            // Simulating a shift: remove first character and append it to the back
            char firstChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(firstChar);
        }
        
        return false;
    }
}