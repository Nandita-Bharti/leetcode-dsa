class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0 , result , new ArrayList<>());
        return result;
    }
    public void helper(int[] nums , int idx , List<List<Integer>> result , ArrayList<Integer> curr){
        result.add(new ArrayList<>(curr));     
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(nums , i+1 , result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
