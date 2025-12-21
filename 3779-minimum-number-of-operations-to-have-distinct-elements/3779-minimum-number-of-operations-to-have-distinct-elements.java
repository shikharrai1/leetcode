class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        int n = nums.length;
         HashMap<Integer, Integer> freq = new HashMap();
        int dupCount = 0;

        for(int num : nums){
            int count = freq.getOrDefault(num, 0)+1;
            freq.put(num, count);
            if(count == 2){
                dupCount++;
            }
        }

        int index = 0;

        while(dupCount > 0 && index < n){
            ops++;

            for(int i=0; i<3 && index < n ; i++){
                int val = nums[index];
                int count = freq.get(val);

                if(count == 2){
                    dupCount--;
                }

                freq.put(val, count-1);

                if(count - 1 == 0){
                    freq.remove(val);
                }
                index++;
            }
        }
        return ops;
    }

}