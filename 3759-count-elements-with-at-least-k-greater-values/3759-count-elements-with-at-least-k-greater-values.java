class Solution {
    public int countElements(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        // Now count for each element 
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            int ele = nums[i];
            int ind = upperBound(arr,ele);
            if(arr.length-1-ind >= k){
                cnt++;
            }
        }
        return cnt;
    }
    int upperBound(int arr[], int target){
        int ans = 0;
        int si = 0;
        int ei = arr.length-1;
        while(si <= ei){
            int mid = (si+ei)/2;
            if(arr[mid] <= target){
                ans = mid;
                si = mid+1;
            }else {
                ei = mid-1;
            }
        }
        return ans;
    }
//   Arrays.sort(nums);
//   int reversed[] = new int[nums.length];
//   for(int i=nums.length-1, j=0; i>=0; i--,j++){
//          reversed[j] = nums[i];
//   }
//   int prefix[] = new int[nums.length];
//   prefix[0] = 0;
//   for(int i=1; i<reversed.length; i++){
//           if(reversed[i] > reversed[i-1]){
//             prefix[i] = prefix[i-1] + 1;
//           }else{
//              prefix[i] = prefix[i-1];
//           }
//   }
//     int cnt = 0;
//   for(int i = 0; i<prefix.length; i++){
//            if(prefix[i] > k) cnt++;
//   }
//   return cnt;

}