class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }
    public int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid+1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
    public void merge(int[] nums, int low, int mid, int high){
        int left = low, right = mid+1;
        List<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){

            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= high){
            temp.add(nums[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            nums[i] = temp.get(i-low);
        }
    }
    public int countPairs(int[] nums, int low, int mid, int high){
        int cnt = 0;
        int right = mid+1;
        for(int i = low; i <= mid; i++){
            while(right <= high && nums[i] > (long) 2 * nums[right]) right++;
            cnt += (right - (mid+1));
        }
        return cnt;
    }
}