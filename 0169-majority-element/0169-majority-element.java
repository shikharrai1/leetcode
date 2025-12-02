class Solution {
    public int majorityElement(int[] nums) {
        //--------------------App1(Brute Force)---------------------------
        for(int i=0; i<nums.length; i++){
            int ele = nums[i];
            int cnt = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j] == ele) cnt++;
            }
            if(cnt > Math.floor(nums.length/2)) return nums[i];
        }
        return -1;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        // }
        // // Now Traverse the hm to find the element that appears more than floor of n/2 times
        // for(int key : hm.keySet()){
        //     if(hm.get(key) > Math.floor(nums.length/2)) return key;
        // }
        // return -1;
    }
}