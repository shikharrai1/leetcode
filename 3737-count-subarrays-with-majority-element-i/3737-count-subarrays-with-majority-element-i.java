class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        // int ans = 0;
        // for(int i=0; i<nums.length; i++){
        //     int eleEqToTarget = 0;
        
        //     for(int j=i; j<nums.length; j++){
        //           if(nums[j] == target) eleEqToTarget++;
        //            if(eleEqToTarget > (j-i+1)/2) ans++;
        //     }
        // }
        // return ans;

        // -------------------------App 2--------------------------
        // construct an array which indicates no. of times target appears till a particular index
        int cntTarget[] = new int[nums.length];
        cntTarget[0] = (nums[0] == target) ? 1 : 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == target){
                cntTarget[i] = cntTarget[i-1] + 1;
            }else{
                cntTarget[i] = cntTarget[i-1];
            }
        }
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(cntTarget[j] - (i > 0 ? cntTarget[i-1] : 0) > (j-i+1)/2){
                    ans++;
                }
            }
        }
        return ans;
    }
}