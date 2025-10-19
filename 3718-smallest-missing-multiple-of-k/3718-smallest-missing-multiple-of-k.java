class Solution {
    public int missingMultiple(int[] nums, int k) {
    //     int i = k;
    //     while(helper(nums,i)){
          
    //     i = i+k;
    // }
    //  return i;
    // }
    // // helper
    // public boolean helper(int nums[], int target){
    //     for(int num : nums){
    //         if(num == target) return true;
    //     }
    //     return false;
    HashSet<Integer> set = new HashSet<>();
    for(int num : nums){
        set.add(num);
    }
    int multiple = k;
    while(set.contains(multiple)){
        multiple += k;
    }
    return multiple;
    }
}