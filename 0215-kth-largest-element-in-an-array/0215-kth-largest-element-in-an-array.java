class Solution {
    public int findKthLargest(int[] nums, int k) {
        // App 1
        // Arrays.sort(nums);
        // return nums[nums.length-k];

        // App 2
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.add(num);
        }
        int count = 0;
        int r = 0;
        while(count != k){
             r = pq.remove();
            count++;
        }
      
        return r;
    }
}