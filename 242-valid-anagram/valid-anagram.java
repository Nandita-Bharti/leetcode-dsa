class Solution {
    public HashMap<Character, Integer> makeFreqMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }
            else{
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        return map;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> mp1 = makeFreqMap(s);
        HashMap<Character, Integer> mp2 = makeFreqMap(t);
        return mp1.equals(mp2);
    }
}