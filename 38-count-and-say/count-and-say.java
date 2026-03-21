class Solution {
    public String countAndSay(int n){
        String ans = "";
        if(n == 1){
          return "1"; 
        }
        String s = countAndSay(n-1);
        int i = 0,  j = 0;
       while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            else{
                int freq = j - i;
                ans += freq;
                ans += s.charAt(i);
                i = j;
            }
        }
        ans += j-i;
        ans += s.charAt(i);
        return ans;
    }
}