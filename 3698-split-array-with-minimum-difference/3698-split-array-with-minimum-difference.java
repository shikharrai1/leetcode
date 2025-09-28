class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long [] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        // create boolean isInc and boolean isDec array
        boolean[] isInc = new boolean[n];
        boolean[] isDec = new boolean[n];

        isInc[0] = true;
        for(int i=1; i<n; i++){
            isInc[i] = isInc[i-1] && (nums[i] > nums[i-1]);
        }

        isDec[n-1] = true;
        for(int i=n-2; i>=0; i--){
            isDec[i] = isDec[i+1] && (nums[i] > nums[i+1]);
        }

        long minDiff = Long.MAX_VALUE;
        boolean found = false;

        for(int i=0; i<n-1; i++){
           if(isInc[i] && isDec[i+1]){
            found = true;
            long leftSum = prefix[i];
            long rightSum = prefix[n-1] - prefix[i];
            long diff = Math.abs(leftSum-rightSum);
            minDiff = Math.min(minDiff,diff);
           }
        }
     
      
       return found ? minDiff : -1;
    }
      
}