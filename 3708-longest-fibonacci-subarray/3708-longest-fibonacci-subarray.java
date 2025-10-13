class Solution {
    public int longestSubarray(int[] nums) {
        // base case
        if(nums.length > 0 && nums.length <= 2) return nums.length;
        int count = 2;
        int maxCount = 2;
        for(int i=2; i<nums.length; i++){
            if(nums[i-2] + nums[i-1] == nums[i]){
                count++;
                maxCount = Math.max(maxCount,count);
            }else{
                count = 2;
            }
        }
        return maxCount;
    }
}