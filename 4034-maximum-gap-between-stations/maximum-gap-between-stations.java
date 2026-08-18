class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length() , m = station.length();
        int[] left = new int[n];
        int[] right = new int[n];

        int pos = 0;
        for(int i = 0; i < n; i++){
            while(station.charAt(pos) != skill.charAt(i)) pos++;
            left[i] = pos;
            pos++;
        }
            pos = m-1;
            for(int i = n-1; i >= 0; i--){
                while(station.charAt(pos) != skill.charAt(i)) pos--;
                right[i] = pos;
                pos--;
            }
        int gap = 0;
        for(int i = 1; i < n; i++){
            gap = Math.max(gap , right[i]-left[i-1]);
        }
        return gap;
    }
}