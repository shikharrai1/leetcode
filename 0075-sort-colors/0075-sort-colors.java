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
     for(int i=cntZero; i<cntZero+cntOne; i++){
        nums[i] = 1;
    }
   for(int i=cntOne+cntZero; i<cntOne+cntZero+cntTwo; i++){
        nums[i] = 2;
    }
    }
}