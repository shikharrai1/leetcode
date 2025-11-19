class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<bloomDay.length; i++){
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }
        int ans = -1;
        int low = min;
        int high = max;
         
        while(low <= high){
            int buquet = m;
            int mid = (low+high)/2;
             int cnt = 0;
            for(int i=0; i<bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    cnt++;
                    if(cnt == k) {
                        buquet = buquet-1;
                        if(buquet == 0){
                             ans = mid;
                             break;
                        }
                        cnt = 0;
                    }
                }else{
                    cnt = 0;
                }
            }
            if(ans != -1 && buquet == 0) {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}