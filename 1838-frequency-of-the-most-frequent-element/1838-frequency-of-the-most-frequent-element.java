class Solution {
    public int maxFrequency(int[] nums, int k) {
        //---------------Brute Force Approach-------------------
        // Arrays.sort(nums);
        // int maxCnt = 1;
        // boolean maxCntInc = false;
        // for(int i=1; i<nums.length; i++){
        //     int ops = k;
        //     int cnt = 0;
        //     for(int j = i-1; j>=0; j--){
        //         boolean upLift = false;
        //         if(nums[i] - nums[j] <= ops){
        //             upLift = true;
        //             maxCntInc = true;
        //             cnt++;
        //             ops = ops - (nums[i] - nums[j]);
        //         }
        //         if(!upLift) break;
        //     }
        //     maxCnt = Math.max(maxCnt, cnt);
        // }
        // if(maxCnt >= 1 && maxCntInc) return maxCnt + 1;
        // return maxCnt;
        

        // --------------------------Better Approach -------------------------
    //     Arrays.sort(nums);
    //        int maxFreq = 1;
    //          int prefixSum[] = new int[nums.length];
    //      prefixSum[0] = nums[0];
    //      for(int i=1; i<prefixSum.length; i++){
    //         prefixSum[i] = prefixSum[i-1] + nums[i];
    //      }
    //     for(int i=1; i<nums.length; i++){
    //         int freq = BS(i, nums, k, prefixSum);
    //         maxFreq = Math.max(freq, maxFreq);
    //     }
    //     return maxFreq;
    // }

    // // ----------------------------function BS()---------------------------
    // int BS(int target_idx, int arr[], int k, int prefixSum[]){
       
       
    //      int l = 0;
    //      int r = target_idx;
    //       int result = target_idx;
    //      while(l <= r){
    //         int mid = (l+r)/2;
    //         // count number of elements b/w mid and r
    //         int cnt = target_idx - mid + 1;
    //         // now what would be sum of these elements if i made all of them equal to nums[target_idx]
    //         int windowSum = cnt*(arr[target_idx]);
    //         int originalSum = prefixSum[target_idx] - prefixSum[mid] + arr[mid];
    //         // now what will be the number of operations that will be needed to make all the elements in given window equal to nums[target_idx]
    //         int ops = windowSum - originalSum;
    //         // now lets check if we have this much operations
    //         if(ops > k){
    //             // we need to decrease our window as we can not uplift this much elements to nums[target_idx]
    //             l = mid+1;
    //         }else{
    //             // it is possible to uplift this much elements to nums[target_idx] we will try to include more elements in our window
    //              result = mid;
    //             r = mid-1;
    //         }
    //      }
    //      return target_idx - result + 1;
       


       //-------------------Optimal Solution(using Sliding Window App.)-----------------------
       Arrays.sort(nums);
       long currSum = 0;
       int l = 0;
       int maxFreq = 0;
       for(int r=0; r<nums.length; r++){
        long target = nums[r];
        currSum += nums[r];
    

        while(l <= r && (r-l+1)*target - currSum > k){
            currSum -= nums[l];
         
            l++;
          
        }
        maxFreq = Math.max(maxFreq, r-l+1);
       }
       return maxFreq;
    }
}