class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cntZero = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                list.add(nums[i]);
            }else{
                cntZero++;
            }
        }
        // now assign elements of list in the original array (nums) then also put cntZero number of zeros at the end of the array
        for(int i = 0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
        for(int i = 0, j = list.size(); i<cntZero; i++,j++){
            nums[j] = 0;
        }
    }
}