class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // Edge Case: A prefix sum of 0 has occurred once (representing an empty subarray)
        //map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            // If (prefixSum - k) exists in the map, it means there are 
            // 'n' subarrays ending here that sum to k.
            if(prefixSum == k) count += 1;
            if(map.containsKey(prefixSum - k)) count += map.get(prefixSum - k);

            // Update the frequency of the current prefix sum in the map
            map.put(prefixSum , map.getOrDefault(prefixSum,0) + 1);
        }
        return count;
    }
}