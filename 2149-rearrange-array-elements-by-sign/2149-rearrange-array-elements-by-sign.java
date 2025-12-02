class Solution {
    public int[] rearrangeArray(int[] nums) {
    int [] positives = new int[nums.length/2];
    int [] negatives = new int[nums.length/2];
        //add positive elements in positives arr and negative element in negatives arr
        for(int i=0,j=0,k = 0; i<nums.length; i++){
            if(nums[i] > 0){
                positives[j] = nums[i];
                j++;
            }else{
                negatives[k] = nums[i];
                 k++;
            }
        }
     
      int [] ans = new int[nums.length];
       int i = 0; // iterate over positive arr
       int j = 0; // iterate over negative arr
        for(int k = 0; k<ans.length/2; k++,i++,j++){
            ans[2*k] = positives[i];
            ans[2*k+1] = negatives[j];
        }
        return ans;
    }
}