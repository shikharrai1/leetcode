class MedianFinder {
PriorityQueue<Integer> LeftMaxHeap;
PriorityQueue<Integer> RightMinHeap;
    public MedianFinder() {
        LeftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        RightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // base case
        if(LeftMaxHeap.size() == 0){
            LeftMaxHeap.add(num);
        }else{
            // compare 'num' with top of LeftMaxHeap to decide in which heap this 'num' will go
            if(LeftMaxHeap.peek() > num){
                // add 'num' in LeftMaxHeap
                LeftMaxHeap.add(num);
            }else{
                // add 'num' in RightMinHeap
                RightMinHeap.add(num);
            }
            // make sure that LeftMaxHeap.size() is either equal to RightMinHeap.size() or LeftMaxHeap.size()-1 is equal to RightMinHeap.size() 
            // it means difference can be atMost 1
           if(LeftMaxHeap.size() -1 > RightMinHeap.size()){
            // move top of LeftMaxHeap into RightMinHeap
            int temp = LeftMaxHeap.peek();
            LeftMaxHeap.remove();
            RightMinHeap.add(temp);
           }else if(RightMinHeap.size() > LeftMaxHeap.size()){
            // here if size of RightMinHeap is greater than size of LeftMaxHeap
            int temp = RightMinHeap.peek();
            RightMinHeap.remove();
             LeftMaxHeap.add(temp);
           }
        }
    }
    
    public double findMedian() {
        if(LeftMaxHeap.size()  == RightMinHeap.size()){
            return (LeftMaxHeap.peek() + RightMinHeap.peek())/2.0;
        }else{
            return LeftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */