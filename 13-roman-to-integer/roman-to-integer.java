class Solution {
    public int romanToInt(String s) {
        int n = s.length() , ans = 0;
        if(n == 1) return helper(s.charAt(0));
        for(int i = 0; i < n; i++){
            char c1 = s.charAt(i);
            if(i < n-1 && helper(c1) < helper(s.charAt(i+1))){
                ans += helper(s.charAt(i+1)) - helper(c1);
                i++;
            }
            else{
                ans += helper(c1);
            }
        }
        return ans;
    }
    public int helper(Character c){
        switch(c){
        case 'I':return 1;
        case 'V':return 5;
        case 'X':return 10;
        case 'L':return 50;
        case 'C':return 100;
        case 'D':return 500;
        case 'M':return 1000;
        default:return 0;
        }
    }
}