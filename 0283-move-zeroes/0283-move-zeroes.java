class Solution {
    public void moveZeroes(int[] nums) {
// ----------------------------App1 Brute Force-----------------------------------
        // List<Integer> list = new ArrayList<>();
        // int cntZero = 0;
        // for(int i = 0; i<nums.length; i++){
        //     if(nums[i] != 0){
        //         list.add(nums[i]);
        //     }else{
        //         cntZero++;
        //     }
        // }
        // // now assign elements of list in the original array (nums) then also put cntZero number of zeros at the end of the array
        // for(int i = 0; i<list.size(); i++){
        //     nums[i] = list.get(i);
        // }
        // for(int i = 0, j = list.size(); i<cntZero; i++,j++){
        //     nums[j] = 0;
        // }

    //-----------------------------App2 Optimal Solution-----------------------
    // int i = 0;
    // int j = 0;
    // while(i < nums.length && j < nums.length){
    //     // move j until it points to an index that has zero
    //     while(nums[j] != 0 && j<nums.length-1){
    //         j++;
    //     }
    //     // make sure that i points to a nonZero element right after j points to a zero element  
    //     if(j < nums.length-1){
    //         i = j+1;
    //          // keep moving i towards right until it points to a non-zero element
    //     while(nums[i] == 0 && i < nums.length-1){
    //         i++;
    //     }
    //     }
       
    //     // now j points to an index that has zero and i points to an element that has nonZero element
    //     // now swap nums[i] with nums[j]
    //    if(i > j){
    //      int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    //    }

    //     j++;
    // }

    //-----------------------------App2 Optimal Solution By Striver-----------------------
    int j = -1;
    // find first index that has zero 
    for(int i = 0; i<nums.length; i++){
        if(nums[i] == 0){
            j = i;
            break;
        }
    }
// now j points to first 0 in the array 'nums'
if(j != -1){
        for(int i = j+1; i<nums.length; i++){
        if(nums[i] != 0){
            // swap nums[i] with nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            j++;
        }
    }
}
    }
}