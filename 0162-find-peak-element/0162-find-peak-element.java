class Solution {
    public int findPeakElement(int[] nums) {
        // edge cases
        if(nums.length == 1) return 0;
        if(nums.length >=2 && nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        int i=1;
        for(; i<=nums.length-2; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) break;
        }
        return i;
    }
}