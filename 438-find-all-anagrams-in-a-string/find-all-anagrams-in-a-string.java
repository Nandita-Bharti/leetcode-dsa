class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length() , m = p.length();
        List<Integer> res = new ArrayList<>();
        if(m > n) return res;
        int[] need = new int[26];
        for(char c : p.toCharArray()){
            need[c-'a']++;
        }
        int[] window = new int[26];
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            window[c-'a']++;
            if(i >= m) window[s.charAt(i-m)-'a']--;
            if(i >= m-1 && Arrays.equals(window , need)) res.add(i-m+1);
        }
        return res;
    }
}