class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
         // prefix sum
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
         // suffix minimum
        long[] suffixMin = new long[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
       
        long score = Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long currScore = prefixSum[i] - suffixMin[i + 1];
            score = Math.max(score, currScore);
        }
        return score;
    }
}