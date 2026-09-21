class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";
        for(String s : words){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String curr = new String(c);
            if(!prev.equals(curr)){
                ans.add(s);
                prev = curr;
            }
        }
        return ans;
    }
}