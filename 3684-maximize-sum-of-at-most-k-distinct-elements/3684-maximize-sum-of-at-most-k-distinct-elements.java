class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        //  sort nums in descending order
     int n = nums.length;
      for(int i=0; i<n-1; i++){
        int maxIdx = i;
        for(int j=maxIdx+1; j<n; j++){
          if(nums[j] > nums[maxIdx]){
            maxIdx = j;
          }
      }
      // swap nums[maxIdx] and nums[i]
      int temp = nums[i];
     nums[i] = nums[maxIdx];
     nums[maxIdx] = temp;
      }

        // pick 1st k distinct elements from nums
        List<Integer> list = new ArrayList<>();

       for(int i=0; i<nums.length; i++){
        
               if(list.size() < k && !list.contains(nums[i])){
                list.add(nums[i]);
               }
        
         if(list.size() == k){
            break;
         }
       }
       // convert list into array and return
       int [] finalAns = new int[list.size()];
       for(int i=0; i<list.size(); i++){
           finalAns[i] = list.get(i);
       }
       return finalAns;
    }
}