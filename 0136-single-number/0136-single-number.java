class Solution {
    public int singleNumber(int[] nums) {
        //----------------------------Brute Force-----------------------------
     for(int i=0; i<nums.length; i++){
        int currEle = nums[i];
        int cnt = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] ==  currEle) cnt++;
        }
        if(cnt == 1) return nums[i];
     }
     return -1;
     
//----------------------------Optimal Solution-------------------------------
        //   int xor = 0;
        // for(int num : nums){
        //     xor ^= num; 
        // }
        // return xor;
    }
}