class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0 , high = arr.length-1;
        while(low <= high){
            int mid = (high+low)/2;
            int correctNo = mid+1;
            int missingNo = arr[mid] - correctNo;
            if(missingNo >= k) high = mid-1;
            else low = mid+1;
        }
        return high+1+k;
    }
}