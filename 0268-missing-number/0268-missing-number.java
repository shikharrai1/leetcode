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
//--------------------------App2--------------------------------
        // List<Integer> list = new ArrayList<>();
        // for(int i=0; i<nums.length; i++){
        //     list.add(nums[i]);
        // }
        // for(int i=0; i<=nums.length; i++){
        //     if(!(list.contains(i))){
        //         return i;
        //     }
        // }
        // return -1;

//--------------------------App3--------------------------------
int present[] = new int[nums.length+1];
for(int i=0; i<nums.length; i++){
    present[nums[i]]++;
}
   for(int i=0; i<present.length; i++){
    if(present[i] == 0){
        return i;
    }
   }
   return -1;
    }
}