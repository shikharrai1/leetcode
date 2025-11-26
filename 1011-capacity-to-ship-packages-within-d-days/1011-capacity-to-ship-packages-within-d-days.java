class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int i=0; i<weights.length; i++){
            left = Math.max(weights[i], left);
            right += weights[i];
        }
        int totSum = right;
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
            int needed = countDays(weights, mid);
            if(needed <= days){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    // countDays
    int countDays(int[] weights, int capacity){
        int days = 1;
        int currentLoad = 0;
        for(int w : weights){
            if(currentLoad + w > capacity){
                days++;
                currentLoad = w;
            }else{
                currentLoad += w;
            }
        }
        return days;
    }
}