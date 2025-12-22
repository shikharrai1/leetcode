class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i=nums.length-1;
        for(; i>=0; i--){
            if(!set.add(nums[i])){
                 // Duplicate found
                  break;
            }
        }
        // first duplicate found at index 'i'
        // we have to remove elements upto index 'i'
        // So count number of operations needed to remove 1st 'i+1' elements of the array
         // In one operation we can remove 3 elements
         // So number of operation needed will be...
         int ops = (i+1)/3 + ((i+1)%3 != 0 ? 1 : 0);
         return ops;
    }
}