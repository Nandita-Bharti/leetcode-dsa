class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> ans = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(words[i].charAt(j) == x){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}