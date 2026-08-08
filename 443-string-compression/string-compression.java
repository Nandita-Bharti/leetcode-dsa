class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 1) return 1;
        int i = 0, j = 0, k = 0, count = 0;
        while(j < n){
            if(chars[i] == chars[j]){
                count++;
                j++;
            }
            else{
                chars[k++] = chars[i];
                if(count > 1){
                    String c = String.valueOf(count);
                    for(char ch : c.toCharArray()){
                        chars[k++] = ch;
                    }
                }
                i = j;
                count = 0;
            }
        }
        chars[k++] = chars[i];
        if(count > 1){
            String c = String.valueOf(count);
                for(char ch : c.toCharArray()){
                    chars[k++] = ch;
                }
        }
        return k;
    }
}