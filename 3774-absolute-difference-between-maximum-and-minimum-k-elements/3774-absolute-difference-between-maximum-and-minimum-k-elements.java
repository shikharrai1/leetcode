class Solution {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int kLargest = 0;
        int kSmallest = 0;
        for(int i=0; i<k; i++){
            kSmallest += nums[i];
        }
        for(int i=nums.length-1; i>=n-k;i--){
            kLargest += nums[i];
        }
        return Math.abs(kLargest - kSmallest);
    }
}