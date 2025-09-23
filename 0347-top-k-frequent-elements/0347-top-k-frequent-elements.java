class Pair implements Comparable<Pair>{
    int num;
    int count;

    // constructor
    Pair(int num, int count){
        this.num = num;
        this.count = count;
    }
    @Override
    public int compareTo(Pair p2){
       return  this.count - p2.count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // traverse the hm and add element and its frequency in the form of object of Pair class
        Set<Integer> keys = hm.keySet();
        for(int key : keys){
            Pair p = new Pair(key,hm.get(key));
            pq.add(p);
        }
        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            Pair p = pq.remove();
            ans[i] = p.num;
        }
        return ans;
    }
}