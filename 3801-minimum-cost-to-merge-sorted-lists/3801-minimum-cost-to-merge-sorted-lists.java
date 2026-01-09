class Solution {
    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int FULL = 1 << n;

        // Precompute merged lists, lengths, and medians
        List<int[]> merged = new ArrayList<>(FULL);
        for (int i = 0; i < FULL; i++) merged.add(null);

        int[] length = new int[FULL];
        int[] median = new int[FULL];

        // Precompute for each mask
        for (int mask = 1; mask < FULL; mask++) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    // Add all elements from lists[i] to temp
                    for (int x : lists[i]) temp.add(x);
                }
            }

            // Convert to sorted array
            temp.sort(Integer::compare);
            int[] arr = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) arr[i] = temp.get(i);

            merged.set(mask, arr);
            length[mask] = arr.length;

            // median definition: left middle for even
            int m = arr.length;
            median[mask] = arr[(m - 1) / 2];
        }

        // DP array
        long[] dp = new long[FULL];
        Arrays.fill(dp, Long.MAX_VALUE);

        // Base cases: single list costs 0
        for (int i = 0; i < n; i++) {
            dp[1 << i] = 0;
        }

        // Fill dp
        for (int mask = 1; mask < FULL; mask++) {

            // Enumerate submasks
            for (int s = (mask - 1) & mask; s > 0; s = (s - 1) & mask) {
                int t = mask ^ s;
                if (t == 0) continue;

                long cost = length[s] + length[t] + 
                            Math.abs(median[s] - median[t]);

                dp[mask] = Math.min(dp[mask], dp[s] + dp[t] + cost);
            }
        }

        return dp[FULL - 1];
    }
}
