class Solution {
    public int minMoves(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        int totSum = 0;
        for(int i=0; i<nums.length; i++){
            totSum += nums[i];
            maxEle = Math.max(maxEle, nums[i]);
        }
      
        return maxEle*nums.length - totSum;
    }
}