class Solution {
    public int beautySum(String s) {
        int n = s.length() , totalBeauty = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String sub = s.substring(i , j+1);
                totalBeauty += getBeauty(sub);
            }
        }
        return totalBeauty;
    }
    int getBeauty(String sub){
        int[] freq = new int[26];
        for(char c : sub.toCharArray()){
            freq[c - 'a']++;
        }
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for(int ele : freq){
            if(ele > 0){
                maxFreq = Math.max(maxFreq , ele);
                minFreq = Math.min(minFreq , ele);
            }
        }
        return (maxFreq == minFreq)? 0 : maxFreq - minFreq;
    }
}