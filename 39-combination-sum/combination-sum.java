class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0 , target, result , new ArrayList<>());
        return result;
    }
    public void helper(int[] nums , int idx , int target , List<List<Integer>> result , ArrayList<Integer> curr){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || idx == nums.length) return;
            curr.add(nums[idx]);
            helper(nums , idx, target-nums[idx], result, curr);
            curr.remove(curr.size() - 1);
            helper(nums , idx+1 , target, result , curr);
    }
}