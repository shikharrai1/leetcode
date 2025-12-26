class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> badCounts = new HashMap<>();
        int totalBad = 0;

        // 1. Count combined frequencies and identify bad positions
        for (int i = 0; i < n; i++) {
            // Feasibility check prep: count total occurrences of each value
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            freq.put(forbidden[i], freq.getOrDefault(forbidden[i], 0) + 1);

            // Identify collisions
            if (nums[i] == forbidden[i]) {
                totalBad++;
                badCounts.put(nums[i], badCounts.getOrDefault(nums[i], 0) + 1);
            }
        }

        // 2. Check Feasibility
        // If any value appears more than n times in total across nums and forbidden,
        // it means by Pigeonhole Principle, we can't avoid a collision.
        // There are n slots. A value 'v' appears 'count' times in nums.
        // It is forbidden in 'forbid' slots.
        // 'count' items must go into 'n - forbid' slots.
        // So we need count <= n - forbid => count + forbid <= n.
        // freq map stores count + forbid.
        for (int count : freq.values()) {
            if (count > n) {
                return -1;
            }
        }

        // 3. Calculate swaps
        // If no bad positions, 0 swaps.
        if (totalBad == 0) return 0;

        int maxBadFreq = 0;
        for (int count : badCounts.values()) {
            maxBadFreq = Math.max(maxBadFreq, count);
        }

        // Formula: max( ceil(totalBad / 2), maxBadFreq )
        // (totalBad + 1) / 2 implements ceiling for integer division
        return Math.max((totalBad + 1) / 2, maxBadFreq);
    }
}