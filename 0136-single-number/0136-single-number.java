class Solution {
    int xor = 0;
    public int singleNumber(int[] nums) {
        for(int num : nums){
            xor ^= num; 
        }
        return xor;
    }
}