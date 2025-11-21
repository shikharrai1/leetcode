class Solution {
    public int removeDuplicates(int[] nums) {
//--------------------------App1 Brute Force -----------------------------------
    //     Set<Integer> set = new LinkedHashSet<>();
    //     for(int i=0; i<nums.length; i++){
    //         set.add(nums[i]);
    //     }
    //     int i = 0;
    //     for(int ele : set){
    //         nums[i] = ele;
    //         i++;
    //     }
    //     return i;
  

//------------------------------- App2 Optimal Sol -----------------------------------
int i = 0;
int j = 0;
while(j < nums.length-1){
    while(j < nums.length-1 && nums[j] == nums[i]){
        j++;
   }
    if(nums[i] != nums[j]){
      i++;
      nums[i] = nums[j];
     }
}
return i+1;
}
}