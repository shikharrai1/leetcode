class Solution {
    public int findKthLargest(int[] nums, int k) {
        // App 1
        // Arrays.sort(nums);
        // return nums[nums.length-k];

        // ---------------------------------App 2----------------------------
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int num : nums){
        //     pq.add(num);
        // }
        // int count = 0;
        // int r = 0;
        // while(count != k){
        //      r = pq.remove();
        //     count++;
        // }
      
        // return r;

        //----------------------App3---------------------------------------
        // form a minHeap with first k elements of array
        // heapify---minHeap
         int n = nums.length;
         int [] heap = new int[k];
         for(int i=0; i<k; i++){
            heap[i] = nums[i];
         }
          for (int i = k / 2 - 1; i >= 0; i--) {
            Heapify(heap, i);
        }

        for(int i=k; i<n; i++){
            if(heap[0] < nums[i]){
                // replace heap[0] with nums[i]
               
                heap[0] = nums[i];
                
                Heapify(heap,0);
            }
        }
        // now Heap has k Largest element now get the kth largest element
          return heap[0];
       
    }
        public void Heapify(int []arr, int idx){
            int size = arr.length;
            int minIdx = idx;
            int left = 2*idx + 1;
            int right = 2*idx + 2;

            if(left < size && arr[left] < arr[minIdx]){
                minIdx = left;
            }
            if(right < size && arr[right] < arr[minIdx]){
                minIdx = right;
            }

            // swap(idx, minIdx)
            if(minIdx != idx){
                int temp = arr[idx];
                arr[idx] = arr[minIdx];
                arr[minIdx] = temp;

                Heapify(arr,minIdx);
            }
        }
      
}