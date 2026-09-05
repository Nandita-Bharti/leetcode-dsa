class Solution {
    public int removeDuplicates(int[] nums) {
        int k =0 , n = nums.length , i = 0 , j = 0 , c = 0;
        while(i < n && j < n){
            if(nums[i] == nums[j]){
                j++;
                c++;
            }
            else{
                if(c >= 2){
                    for(int z = 0; z < 2; z++){
                        nums[k++] = nums[i];
                    }
                }
                else{
                    nums[k++] = nums[i];
                }
                i = j;
                c = 0;
            }
        }
        if(c >= 2){
            for(int z = 0; z < 2; z++){
                nums[k++] = nums[i];
            }
        }else{
            nums[k++] = nums[i];
        }
        
        
        return k;
    }
}


// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int x = 2;
//         int n = nums.length;
//         if(n <= 2) return n;
//         for(int j = 2; j < n; j++){
//             if(nums[j] != nums[x-2]){
//                 nums[x] = nums[j];
//                 x++;
//             }
//         }
//         return x;
//     }
// }