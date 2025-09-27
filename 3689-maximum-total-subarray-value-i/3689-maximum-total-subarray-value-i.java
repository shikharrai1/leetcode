class Solution {
    public long maxTotalValue(int[] nums, int k) {
        // get the max and min of this 'nums' array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        return (long)(max-min)*k;
    }
}