class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
//-------------------------------------App1------------------------------------------
        // Arrays.sort(nums);
        // return nums[nums.length-1] +  nums[nums.length-2] - nums[0];

//-------------------------------------App2------------------------------------------
int min = Integer.MAX_VALUE;
int max1 = Integer.MIN_VALUE;
int max2 = Integer.MIN_VALUE;

for(int num : nums){
    if(num < min) min = num;

    if(num > max1){
        max2 = max1;
        max1 = num;
    }else if(num > max2){
        max2 = num;
    }
}
   return max1 + max2 - min;
    }
}