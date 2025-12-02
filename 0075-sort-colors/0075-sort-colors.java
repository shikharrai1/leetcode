class Solution {
    public void sortColors(int[] nums) {
        //----------------------App1(Brute Force)-----------------------
        Arrays.sort(nums);
     //----------------------App2(Better Sol)---------------
     int cntZero = 0;
     int cntOne = 0;
     int cntTwo = 0;
     for(int i=0; i<nums.length; i++){
        if(nums[i] == 0) cntZero++;
        else if(nums[i] == 1) cntOne++;
        else cntTwo++;
     }
    for(int i=0; i<cntZero; i++){
        nums[i] = 0;
    }
     for(int i=0; i<cntOne; i++){
        nums[i+cntZero] = 1;
    }
   for(int i=0; i<cntTwo; i++){
        nums[i+cntOne+cntZero] = 2;
    }
    }
}