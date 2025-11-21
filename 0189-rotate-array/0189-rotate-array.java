class Solution {
    public void rotate(int[] nums, int k) {
    // ----------------------App1-----------------------------------
        // if(k >= nums.length){
        //    k = k%nums.length;
        // }
        // int ans[] = new int[nums.length];
        // int j = 0;
        // for(int i=nums.length-k; i<nums.length; i++){
        //    ans[j] = nums[i];
        //    j++;
        // }
        // for(int i=0; i<nums.length-k; i++){
        //     ans[j] = nums[i];
        //     j++;
        // }
        // // assign back in nums array
        // for(int i =0; i<ans.length; i++){
        //     nums[i] = ans[i];
        // }

     // ----------------------------App2-----------------------------------
     int n = nums.length;
      if(k >= nums.length){
           k = k%nums.length;
        }
     int temp[] = new int[k];
     for(int i=n-k, j = 0; i<n; i++, j++){
        temp[j] = nums[i];
     }
     // shift elements towards right
     for(int i = n-k-1; i>=0; i--){
        nums[i+k] = nums[i];
     }
     // Now put elements of temp array in the original array in the beginning
     for(int i=0; i<k; i++){
        nums[i] = temp[i];
     }
    }
}