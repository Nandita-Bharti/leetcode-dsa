class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        int n = nums1.length , m = nums2.length;
        for(int num : nums1){
            set.add(num);
        }
        for(int num : nums2){
            if(set.contains(num)) result.add(num);
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for(int num : result){
            ans[i++] = num;
        }
    return ans;
    }
}