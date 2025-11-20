class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num, max);
        }
        max += 1;
        int low = 1;
        int high = max;
        int ans = max;

        while(low <= high){
            int mid = (low+high)/2;
            int result = 0;
            for(int num: nums){
                result += Math.ceil((double)num/mid);
            }
            // check if result is less than equal to threshold
            if(result <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}