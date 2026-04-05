class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: frequency of nums2
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        // Step 2: process nums1
        for (int num : nums1) {
            if (num % k != 0) continue;

            int x = num / k;

            // Step 3: find divisors of x
            for (int d = 1; d * d <= x; d++) {
                if (x % d == 0) {
                    // d is divisor
                    if (map.containsKey(d)) {
                        count += map.get(d);
                    }

                    int other = x / d;
                    if (other != d && map.containsKey(other)) {
                        count += map.get(other);
                    }
                }
            }
        }
        return count;
    }
}