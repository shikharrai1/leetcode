class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //-----------------App1(Brute Force)-----------------------
        // Set<List<Integer>> ans = new HashSet<>();
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         for(int k=j+1; k<nums.length; k++){
        //             for(int l=k+1; l<nums.length; l++){
        //                 if(nums[i]+nums[j]+nums[k]+nums[l] == target){
        //                     // create a List<Integer>
        //                     List<Integer> list = new ArrayList<>();
        //                     list.add(nums[i]);
        //                     list.add(nums[j]);
        //                     list.add(nums[k]);
        //                     list.add(nums[l]);

        //                     Collections.sort(list);
        //                     ans.add(list);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(ans);

        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                Map<Long, String> map = new HashMap<>();
                for(int k=j+1; k<nums.length; k++){
                    long currentSum = (long)nums[i] + (long)nums[j] + (long)nums[k];
                    long fourth = (long)target - currentSum;
                     if(map.containsKey(fourth)){
                        // quadruple found
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)fourth);
                        Collections.sort(list);
                        ans.add(list);
                     }
                     map.put((long)nums[k],"#");
                }
            }
        }
        return new ArrayList<>(ans);
    }
}