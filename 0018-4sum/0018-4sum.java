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

// //-------------------App2(Better Sol)---------------------------------------
//         Set<List<Integer>> ans = new HashSet<>();
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 Map<Long, String> map = new HashMap<>();
//                 for(int k=j+1; k<nums.length; k++){
//                     long currentSum = (long)nums[i] + (long)nums[j] + (long)nums[k];
//                     long fourth = (long)target - currentSum;
//                      if(map.containsKey(fourth)){
//                         // quadruple found
//                         List<Integer> list = new ArrayList<>();
//                         list.add(nums[i]);
//                         list.add(nums[j]);
//                         list.add(nums[k]);
//                         list.add((int)fourth);
//                         Collections.sort(list);
//                         ans.add(list);
//                      }
//                      map.put((long)nums[k],"#");
//                 }
//             }
//         }
//         return new ArrayList<>(ans);

//-----------------------App3(Optimal Sol)------------------------------------
    
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    for(int i=0; i<nums.length; i++){
        if (i > 0 && nums[i] == nums[i-1]) continue;
        for(int j=i+1; j<nums.length; j++){
            // ensure that we do not have duplicate quadruplets
            if (j > i+1 && nums[j] == nums[j-1]) continue;

            int k = j+1;
            int l = nums.length-1;

            while(k < l){
                long sum = nums[i] + nums[j];
                sum += nums[k];
                sum += nums[l];

                if(sum < target){
                    k++;
                }else if(sum > target){
                    l--;
                }else{
                    // sum == target
                   // create a List<Integer> and insert elements in it

                   List<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   list.add(nums[l]);

                   set.add(list);

                   k++;
                   l--;
                   while(k < l && nums[k] == nums[k-1]){
                    k++;
                   }
                   while(k < l && nums[l] == nums[l+1]){
                    l--;
                   }
                }
            }
        }
    }
    return new ArrayList<>(set);
    }
}