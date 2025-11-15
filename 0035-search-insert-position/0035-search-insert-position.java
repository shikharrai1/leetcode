class Solution {
    public int searchInsert(int[] nums, int target) {
        // -------------------------App1------------------------------
        //Edge cases
        if(target <= nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;

        for(int i=0; i<=nums.length-2; i++){
            if(nums[i] == target) return i;
            else if(nums[i] < target &&  target <= nums[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}