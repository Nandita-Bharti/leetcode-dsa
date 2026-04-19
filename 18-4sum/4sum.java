// 1. Brute
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         Set<List<Integet>> set = new HashMap<>();
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     for (int l = k + 1; l < n; l++) {
//                         long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
//                         if(sum == target){
//                             List<Integer> temp = new Array.asList(nums[i], nums[j], nums[k], nums[l]);
//                             Collections.sort(temp);
//                             set.add(temp);
//                         }
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(set);
//     }
// }

//2. Better approach using hashing
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
//         Set<List<Integer>> st = new HashSet<>();

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 Set<Long> hashset = new HashSet<>();
//                 for (int k = j + 1; k < n; k++) {
//                     long sum = (long)nums[i] + nums[j] + nums[k];
//                     long fourth = target - sum;
//                     if (hashset.contains(fourth)) {
//                         List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);
//                         Collections.sort(temp);
//                         st.add(temp);
//                     }
//                     hashset.add((long)nums[k]);
//                 }
//             }
//         }
//         return new ArrayList<>(st);
//     }
// }
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l]));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    } else if(sum > target){
                        l--;
                    }
                    else{
                        k++;
                    }
               }
            }
        }
        return ans;
    }
}
