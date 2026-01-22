class Solution {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> distinctValues = new HashSet<>();
        
        // Find all positions where nums[i] != target[i]
        // and collect distinct values from nums at those positions
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target[i]) {
                distinctValues.add(nums[i]);
            }
        }
        
   
        return distinctValues.size();
    }
}