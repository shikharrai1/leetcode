class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        boolean[] used  = new boolean[nums.length];
        helper(resultList,new ArrayList<>(),nums, used);
        return resultList;
    }
    // helper() function
    public void helper(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, boolean[] used){
        // base case
        if(tempList.size() == nums.length && !resultList.contains(tempList)){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            tempList.add(nums[i]);

            helper(resultList,tempList,nums,used);

            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}