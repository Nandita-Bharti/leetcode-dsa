class Solution {
    public int maxDepth(String s) {
        int open = 0 , max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') open++;
            else if(s.charAt(i) == ')'){
                if(open > max){
                    max = open;
                }
                open--;
            }
        }
        return max;
    }
}