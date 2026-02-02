class Solution {
    public int minimumPrefixLength(int[] nums) {
        int i=nums.length-1;
        for(; i>=1; i--){
            if(nums[i] <= nums[i-1]){
                return i;
            }
        }
         return 0;
    }
}