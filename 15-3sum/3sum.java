import java.util.*;
//1. BRUTE
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int n = nums.length;
//         // Set to store unique triplets (automatically handles duplicates)
//         Set<List<Integer>> st = new HashSet<>();

//         // 1. Pick the first element
//         for (int i = 0; i < n; i++) {
//             // 2. Pick the second element
//             for (int j = i + 1; j < n; j++) {
//                 // 3. Pick the third element
//                 for (int k = j + 1; k < n; k++) {
//                     if (nums[i] + nums[j] + nums[k] == 0) {
//                         // Found a triplet, create a list
//                         List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        
//                         // Sort the triplet so [1, -1, 0] and [0, 1, -1] 
//                         // are treated as the same entry in the Set
//                         Collections.sort(temp);
//                         st.add(temp);
//                     }
//                 }
//             }
//         }

//         // Convert the set back to a List of Lists for the return type
//         return new ArrayList<>(st);
//     }
// }

// 2. Better
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int n = nums.length;
//         // Use a Set to store the unique triplets
//         Set<List<Integer>> st = new HashSet<>();

//         for (int i = 0; i < n; i++) {
//             // Inner Set to store elements seen between i and j
//             Set<Integer> hashset = new HashSet<>();
            
//             for (int j = i + 1; j < n; j++) {
//                 // We need: nums[i] + nums[j] + third = 0
//                 // Therefore: third = -(nums[i] + nums[j])
//                 int third = -(nums[i] + nums[j]);

//                 // If the required 'third' value is in our hashset, we found a triplet
//                 if (hashset.contains(third)) {
//                     List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
//                     // Sort to ensure [1, -1, 0] is treated same as [0, 1, -1]
//                     Collections.sort(temp);
//                     st.add(temp);
//                 }
                
//                 // Add the current element j to the hashset for future checks
//                 hashset.add(nums[j]);
//             }
//         }

//         return new ArrayList<>(st);
//     }
// }

// 3. Optimal
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        
        // 1. Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // 2. Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 3. Two-pointer search
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // Found a triplet
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    // Move pointers
                    j++;
                    k--;

                    // 4. Skip duplicates for the second and third elements
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}