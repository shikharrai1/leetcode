class Solution {
    public long minCost(String s, int[] cost) {
        long totalCost = 0;
        long[] freqCost = new long[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            freqCost[idx] += cost[i];
            totalCost += cost[i];
        }

        long maxKeep = 0;
        for (long c : freqCost) {
            maxKeep = Math.max(maxKeep, c);
        }

        return totalCost - maxKeep;
    }
}