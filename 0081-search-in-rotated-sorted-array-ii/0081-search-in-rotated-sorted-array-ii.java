class Solution {
    public boolean search(int[] nums, int target) {
      
    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] == target) return true;
    //     }
    //     return false;
    // }


    //-----------------------------------App2---------------------------------------------------
int si = 0; 
int ei = nums.length-1;

while(si <= ei){
    int mid = (si+ei)/2;
    if(nums[mid] == target) return true;

    // if si , mid and ei all three indices has the same element
    if(nums[mid] == nums[si] && nums[mid] == nums[ei]){
        si++;
        ei--;
        continue;
    }
    // now Identify Sorted Half
    // check if 1st half is sorted
    if(nums[si] <= nums[mid]){
        // see if target exists in this range i.e., b/w si and ei(mid-1) of nums array
        if(si < mid && nums[si] <= target && target <= nums[mid-1]){
            // if yes then update the ei
                    ei = mid-1;
        }else{
            // otherwise the problem gets reduced to finding target in this range (si = mid+1) and ei
            si = mid+1;
        }

    }else{
        // if first half is not sorted then definitely second half is sorted
        // now check if target exists in the range i.e., b/w mid+1 and ei of nums array
        if(mid < ei && nums[mid+1] <= target && target <= nums[ei]){
             si = mid+1;
        }else{
            ei = mid-1;
        }
    }
}
return false;
}
}

