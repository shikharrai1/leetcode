class Solution {
    int sum = 0;
    public int alternatingSum(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(i % 2 == 0){
                sum += nums[i];
            }else{
                sum -= nums[i];
            }
        }
        return sum;
    }
}