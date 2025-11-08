class Solution {
    public int search(int[] nums, int target) {
                //find pivot
   int pivot =  findPivot(nums);

   //if pivot == -1 means array is not rotated so use normal binary search
   if(pivot == -1){
     return BS(nums, target, 0, nums.length-1);
   }
   //If pivot is found then you have found 2 ascending sorted arrays
   if(nums[pivot] == target){
         return pivot;
   }
   if(target >= nums[0]){
    return BS(nums, target, 0, pivot-1);
   
   }
   // if(nums[0] > target)  then search in 2nd half
    int si = pivot + 1;
  return BS(nums, target, si, nums.length-1);
 }
 public static int findPivot(int nums[]){
  int si = 0;
    int ei = nums.length-1;
    
    while(si <= ei){
         int mid = (si+ei)/2;
         //case 1
         if( mid < ei && nums[mid] > nums[mid+1]){
             return mid;
         }
         //case 2
         else if( mid > si && nums[mid] < nums[mid-1]){
             return mid-1;
         }
         //case 3
         else if(nums[si] > nums[mid]){
             ei = mid-1;
        }
         //case 4
         else {
             si = mid+1;
         }
    }
    return -1;
 }

 //
 public static int BS(int nums[], int target, int si, int ei ){
     while(si <= ei){
         int mid = (si + ei)/2;
         if(target == nums[mid]){
             return mid;
         }
         else if(target > nums[mid]){
             si = mid+1;
         }
         else{
             ei = mid -1;
         }
     }
     return -1;

        
        
    }
}