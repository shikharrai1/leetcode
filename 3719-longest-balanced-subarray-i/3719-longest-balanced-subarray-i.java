class Solution {
    public int longestBalanced(int[] nums) {
        // App 1 ------------gives TLE
    //     int longest = 0;
    //     for(int i=0; i<nums.length; i++){
    //         HashMap<Integer, Integer> hm = new HashMap<>();
    //         for(int j=i; j<nums.length; j++){
                
    //                 hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
              
    //             if(areFrequenciesEqual(hm)){
    //                longest = Math.max(longest,j-i+1);
    //             }
    //         }
    //     }
    //     return longest;
    // }
    // public boolean areFrequenciesEqual(HashMap<Integer,Integer> hm){
    //     int distinctEven = 0;
    //     int distinctOdd = 0;
    //   // just check if number of odd keys is equal to number of even keys
    //   for(Integer key : hm.keySet()){
    //     if(key % 2 == 0){
    //         distinctEven++;
    //     }else{
    //         distinctOdd++;
    //     }

    //   }
    //   return distinctEven == distinctOdd;
    int longest = 0;
    int n = nums.length;
    for(int i=0; i<n; i++){
        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();

        for(int j=i; j<n; j++){
            if(nums[j] % 2 == 0){
                evenSet.add(nums[j]);
            }else{
                oddSet.add(nums[j]);
            }
            if(evenSet.size() == oddSet.size()){
                longest = Math.max(longest,j-i+1);
            }
        }
        
    }
    return longest;
    }
}