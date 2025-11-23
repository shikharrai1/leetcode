class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String, Integer> hm = new HashMap<>();
        int xor = 0;
        int diff = 0;
        int longest = 0;
        hm.put("0#0",-1);
        for(int i = 0; i<nums.length; i++){
            xor = xor^nums[i];
            diff += (nums[i]%2 == 0) ? 1 : -1;
            String key = xor+"#"+diff;
            if(hm.containsKey(key)){
                longest = Math.max(longest,i-hm.get(key));
            }else{
                hm.put(key,i);
            }
        }
     return longest;
    }
}