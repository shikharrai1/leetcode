class Solution {
    public int dominantIndices(int[] nums) {
        int SumOfRightElements[] = new int[nums.length];
        int sum = nums[nums.length-1];
        int cnt = 0;
        
           if(nums.length > 1){
                       for(int i=nums.length-2; i>=0; i--){
         SumOfRightElements[i] = sum;
            sum += nums[i];
        }
        
        for(int i=0; i < SumOfRightElements.length-1; i++){
            if (SumOfRightElements[i]/(nums.length-i-1) < nums[i]){
                cnt++;
            }
        }
           }
        return cnt;
    }
}