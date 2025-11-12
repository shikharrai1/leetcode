class Solution {
    public int findMin(int[] nums) {
        // find pivot then element next to pivot will be answer
        int pivot = -1;
        pivot = findPivot(nums);
        return pivot == -1 ? nums[0] : nums[pivot+1];
    }
    int findPivot(int nums[]){
        int si = 0;
        int ei = nums.length-1;
        while(si <= ei){
            int mid = (si+ei)/2;
            if(mid < ei && nums[mid] > nums[mid+1]){
                return mid;
            }else if(si < mid && nums[mid] < nums[mid-1]){
                return mid-1;
            }else if(nums[mid] < nums[0]){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return -1;
    }
}