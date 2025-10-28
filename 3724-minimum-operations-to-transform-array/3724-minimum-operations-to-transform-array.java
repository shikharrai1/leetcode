class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long ans = 0;

        for(int i=0; i<nums1.length; i++){
            ans += Math.abs(nums1[i] - nums2[i]);
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int l = Math.min(nums1[i], nums2[i]);
            int r = Math.max(nums1[i], nums2[i]);

            if(nums2[n] < l) {
                min = Math.min(min,l-nums2[n]);
            }else if(nums2[n] > r) {
                 min = Math.min(min,nums2[n]-r);
            }else{
                min = 0;
                break;
            }
        }
        ans += min + 1;
        return ans;
    }
}