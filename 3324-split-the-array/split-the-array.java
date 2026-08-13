class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
            if(map.get(num) > 2) return false;
        }
        return true;
    }
}

// class Solution {
//     public boolean isPossibleToSplit(int[] nums) {
//         int n = nums.length;
//         int i = 0 , j = 0 , count = 0;
//         Arrays.sort(nums);
//         while(j < n){
//             if(nums[i]==nums[j]){
//                 count++;
//                 j++;
//                 if(count > 2) return false;
//             }
//             else{
//                 i = j;
//                 count = 0;
//             }

//         }
//         return true;
//     }
// }