class Solution {
    public String triangleType(int[] nums) {
        int s1 = nums[0], s2 = nums[1], s3 = nums[2];

        // Check if a triangle can be formed
        if (s1 + s2 <= s3 || s1 + s3 <= s2 || s2 + s3 <= s1) {
            return "none";
        }

        // Determine the type
        if (s1 == s2 && s2 == s3) {
            return "equilateral";
        } else if (s1 == s2 || s1 == s3 || s2 == s3) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
