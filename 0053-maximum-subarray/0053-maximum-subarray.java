class Solution {
    public int maxSubArray(int[] nums) {
// -------------------------------App1(Brute Force)--------------------------
int longest = Integer.MIN_VALUE;
for(int i=0; i<nums.length; i++){
    int sum = 0;
    for(int j=i; j<nums.length; j++){
          sum += nums[j];
        longest = Math.max(longest, sum);
    }
}
return longest;
    }
}