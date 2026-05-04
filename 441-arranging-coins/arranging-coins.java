class Solution {
    public int arrangeCoins(int n) {
        long m1 = (long) n;
        long m2 = 8*m1+1;
        return (int)(Math.sqrt(m2)-1)/2;
    }
}