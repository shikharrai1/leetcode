class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(), res);
        return res; 
    }
    // helper
    public void helper(int[] candidates, int idx, int target, List<Integer> list, List<List<Integer>> res){

        if(idx >= candidates.length){
            return;
        }
                 // base case
                 if(target == 0){
                    res.add(list);
                    return;
                 }
        // here at every index idx I have a choice of either picking the element at that index or  not picking the element at that index
        // let's pick  candidates[idx] and be at the same index
        if(target >= candidates[idx]){
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(candidates[idx]);
            helper(candidates,idx,target-candidates[idx],tempList,res);
        }
        // do not pick candidates[idx] move to next idx
        helper(candidates,idx+1,target,list,res);
    } 
}