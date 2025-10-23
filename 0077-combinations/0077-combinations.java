class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        helper(n,1,k,new ArrayList<>(),resultList);
        return resultList;
    }
    public void helper(int n, int start, int k, List<Integer> list,List<List<Integer>> resultList){
        // base case
        if(k == 0){
          resultList.add(new ArrayList<>(list));
          return;
        }
         if(start > n){
            return;
        }
        // pick
        list.add(start);
        helper(n,start+1,k-1,list,resultList);
        // do not pick
        list.remove(list.size()-1);
        helper(n,start+1,k,list,resultList);
    }
}