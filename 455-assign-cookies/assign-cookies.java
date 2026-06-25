class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length , m = s.length;
        int l = 0 , r = 0 , child = 0;
        while(l < n && r < m){
            if(g[l] <= s[r]){
                child++;
                l++;
            }
            r++;
        }
        return child;
    }
}