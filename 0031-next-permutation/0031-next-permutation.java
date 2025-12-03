class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                 pivot = i;
                 break;
            }
        }
        if(pivot == -1){
         reverse(nums,0,nums.length-1);
         return;
        }
        // now find the first digit from the right that is greater than nums[pivot]
        for(int i=n-1; i>=0; i--){
            if(nums[i] > nums[pivot]){
                // swap(nums[i], nums[pivot])
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }
        // now reverse elements from pivot+1 to n-1
        reverse(nums,pivot+1,nums.length-1);
    }
    void reverse(int []nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}