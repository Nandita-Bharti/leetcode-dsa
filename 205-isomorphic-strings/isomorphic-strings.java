class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character , Character> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c1 = s.charAt(i) , c2 = t.charAt(i);
          // If c1 has been seen before
            if (map.containsKey(c1)) {
                // It must map to the exact same character c2
                if (map.get(c1) != c2) {
                    return false;
                }
            }
            // If c1 is new, but c2 is already mapped to something else
            else if(map.containsValue(c2)) return false;
            map.put(c1,c2);
        }
        return true;
    }
}