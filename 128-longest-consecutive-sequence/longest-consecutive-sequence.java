class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int n = nums.length , longest = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curNum = num;
                int curCount = 1;
                while(set.contains(curNum+1)){
                    curCount++;
                    curNum++;
                }
                longest = Math.max(longest , curCount);
            }
        }
        return longest;
    }
}