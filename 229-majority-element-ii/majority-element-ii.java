class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int c = 0;
        int n = nums.length;
        int count = n / 3;
        int i = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] == nums[i]){
                c++;
                if(c > count && !ans.contains(nums[j])) ans.add(nums[j]);
            }
            else{
                c = 1;
                i = j;
                if(c > count) ans.add(nums[j]);
            }
        }
        return ans;
    }
}