class Solution {
    public int subarraySum(int[] nums, int k) {
        //--------------------- App1----------------------------- 
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                   sum += nums[j];

                   if(sum == k) count++;
            }
        }
        return count;
        //--------------------------OptimalSol---------------------------
        // int count = 0;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // hm.put(0,1);
        // int prefixSum = 0;
        // for(int i=0; i<nums.length; i++){
        //     prefixSum += nums[i];
        //     if(hm.containsKey(prefixSum - k)) count += hm.get(prefixSum - k);
        //     hm.put(prefixSum, hm.getOrDefault(prefixSum,0)+1);
        // }
        // return count;
    }
}