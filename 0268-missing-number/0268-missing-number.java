class Solution {
    public int missingNumber(int[] nums) {
//--------------------------App1--------------------------------
// for(int i=0; i<=nums.length; i++){
//     int flag = 0;
//     for(int j=0; j<nums.length; j++){
//         if(nums[j] == i){
//             flag = 1;
//             break;
//         }
//     }
//     if(flag == 0){
//         return i;
//     }
// }
// return -1;

//--------------------------App2------------------------------------
// int present[] = new int[nums.length+1];
// for(int i=0; i<nums.length; i++){
//     present[nums[i]]++;
// }
//    for(int i=0; i<present.length; i++){
//     if(present[i] == 0){
//         return i;
//     }
//    }
//    return -1;

//----------------------------------App3------------------------------------
int n = nums.length;
    int OriginalSum = (n*(n+1))/2;
    // calc curr Sum
    int ActualSum = 0;
    for(int x : nums){
        ActualSum += x;
    }
    return OriginalSum-ActualSum;
    }
}