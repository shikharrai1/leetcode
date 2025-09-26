class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums, int idx, List<Integer> list, List<List<Integer>> ans){
        // base case
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // at every index 'idx' there are 2 choices either to take nums[idx] in the list or do not take
        // lets pick nums[idx] in the list
        list.add(nums[idx]);
helper(nums,idx+1,list,ans);
// this time do not pick nums[idx] in the list
list.remove(list.size()-1);
helper(nums,idx+1,list,ans);
    }
}