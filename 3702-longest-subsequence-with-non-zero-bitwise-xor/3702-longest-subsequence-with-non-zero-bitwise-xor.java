class Solution {
    public int longestSubsequence(int[] nums) {
        boolean isAllZero = true;
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                isAllZero = false;
            }
            xor ^= nums[i];
        }
        if(isAllZero){
            return 0;
        }
        return xor == 0 ? nums.length-1 : nums.length;
    }
}