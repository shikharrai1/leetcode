class Solution {
    public int findKthLargest(int[] nums, int k) {
        // App 1
        Arrays.sort(nums);
        return nums[nums.length-k];

        // ----------------------------App 2--------------------------
        // 1st put 1st k integers in an arrayList 
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i=0; i<k; i++){
        //     list.add(nums[i]);
        // }
       
        
        // // now traverse remaining elements in nums and see if nums[i] is greater than smallest element in list
        // for(int i=k; i<nums.length; i++){
        //    // get the smallest element out of these k elements in list
        //    int smallestIdx = 0; // initially assuming that smallest element is present at 0th index of list
        //    for(int j = 1; j<k; j++){
        //        if(list.get(j) < list.get(smallestIdx)){
        //         smallestIdx = j;
        //        }
        //    }
        //    if(nums[i] > list.get(smallestIdx)){
        //          // assign nums[i] at  this 'smallestIdx' of list 
        //          list.remove(smallestIdx);
        //          list.add(smallestIdx,nums[i]);
                 
        //    }
        // }
        // Collections.sort(list);
        // return list.get(0);
} 
}