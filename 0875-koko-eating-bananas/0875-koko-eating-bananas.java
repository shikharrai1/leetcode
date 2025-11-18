class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //------------------App1 Brute Force----------------------------------
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<piles.length; i++){
        //     max = Math.max(piles[i], max);
        // }
        // int speed = 1;
        // while(speed <= max){
        //     int totHours = 0;
        //     for(int i=0; i<piles.length; i++){
        //         totHours += Math.ceil(piles[i]/(float)speed);
        //     }
        //     if(totHours <= h) return speed;
        //     speed++;
        // }
        // return -1;
        int max = Integer.MIN_VALUE;
        int ans = 1;
        for(int i=0; i<piles.length; i++){
            max = Math.max(piles[i], max);
        }

        int min = 1;

        while(min <= max){
            int speed = min + (max-min)/2;
            int totHours = 0;
            // calc totHours with this speed
            for(int i=0; i<piles.length; i++){
                 totHours += Math.ceil((double)piles[i]/speed);
            }
            if(totHours <= h){
                ans = speed;
                max = speed-1;
            }else{
                min = speed+1;
            }
        }
        return ans;
    }
}