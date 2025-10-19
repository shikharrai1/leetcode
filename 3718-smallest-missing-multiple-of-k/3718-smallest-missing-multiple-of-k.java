class Solution {
    public int missingMultiple(int[] nums, int k) {
        int i = k;
        while(helper(nums,i)){
          
        i = i+k;
    }
     return i;
    }
    // helper
    public boolean helper(int nums[], int target){
        for(int num : nums){
            if(num == target) return true;
        }
        return false;
    }
}