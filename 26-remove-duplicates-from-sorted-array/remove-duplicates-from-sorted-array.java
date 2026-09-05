// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int x=0;
//         for(int i=1;i<nums.length;i++){
//             if(nums[x] != nums[i]){
//                 x += 1;
//                 nums[x] = nums[i];
//             }
//         }
//         return x+1;
//     }
// }
class Solution {
    public int removeDuplicates(int[] nums) {
        int k =0 , n = nums.length , i = 0 , j = 0;
        while(i < n && j < n){
            if(nums[i] == nums[j]){
                j++;
            }
            else{
                nums[k++] = nums[i];
                i = j;
            }
        }
        nums[k++] = nums[i];
        return k;
    }
}
