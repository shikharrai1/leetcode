class Solution {
    public long minInversionCount(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int j = i+k-1;
            if(j >= n) break;
                  // now count inversions in this subarray of length k;
                  int count = cntInversion(nums,i,j,k);
                  min = Math.min(min, count);
            
        }
        return min;
    }
    // cntInversion()
    int cntInversion(int nums[], int si, int ei, int k){
        if(ei-si+1 != k) return Integer.MAX_VALUE;
         int cnt = 0;
        for(int i = si; i<ei; i++){
            for(int j=i+1; j<=ei; j++){
                if(nums[i] > nums[j]) cnt++;
            }
        }
        return cnt;
    }
}