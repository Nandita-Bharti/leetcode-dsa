class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int n = hours.length;
        int c = 0;
        for(int i = 0; i < n; i++){
            if(hours[i] >= target) c++;
        }
        return c;
    }
}