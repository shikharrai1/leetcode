class Solution {
    public int[] rearrangeArray(int[] nums) {
    int [] positives = new int[nums.length/2];
    int [] negatives = new int[nums.length/2];
        //add positive elemenst in positives arr and negative element in negatives arr
        for(int i=0,j=0,k = 0; i<nums.length; i++){
            if(nums[i] > 0){
                positives[j] = nums[i];
                j++;
            }else{
                negatives[k] = nums[i];
                 k++;
            }
        }
     
        // an array to return the answer
        int ans[] = new int[nums.length];
        int i =  0; // to iterate on +ve elements
        int j = 0; // to iterate on -ve elements
        int k = 0; // to iterate over ans array
        for(; k<ans.length; k++,i++,j++){
            ans[k] = positives[i];
            k++;
            ans[k] = negatives[j];
        }
        return ans;
    }
}