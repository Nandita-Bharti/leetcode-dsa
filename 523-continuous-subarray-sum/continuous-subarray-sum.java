class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0 , -1);

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(map.containsKey(rem)){
                if(i-map.get(rem) > 1) return true;
            }
            else{
                map.put(rem , i);
            }
        }
        return false;
    }
}