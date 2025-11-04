class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        int nums2[] = new int[n];
        for(int i=0; i<n; i++){
            nums2[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums2);
        if(nums2[n-1] == 0 || nums2[n-2] == 0) return 0;
        return (long)nums2[n-1]*nums2[n-2]*100000;
    }
}