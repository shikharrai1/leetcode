class Solution {
    public int removeDuplicates(int[] nums) {
//--------------------------App1 Brute Force -----------------------------
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


//------------------------------- App2 Optimal Sol ------------------------
int i=0;
for(int j=1; j<nums.length; j++){
    if(nums[j] != nums[i]){
        i++;
        nums[i] = nums[j];
    }
}
return i+1;
}
}