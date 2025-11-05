class Solution {
    public long minimumTime(int[] d, int[] r) {
        long d1 = d[0], d2 = d[1], r1 = r[0], r2 = r[1];
        long low = (d1 + d2);
        long high = 2l*(d1 + d2);

        long ans = high;
        while(low <= high){
            long target = low + (high - low)/2;
            if(isPossible(target, d1, d2, r1, r2)){
                ans = target;
                high = target - 1;
            }else{
                low = target + 1;
            }
        }
        return ans;
    }
    // isPossible()
    boolean isPossible(long time, long d1, long d2, long r1, long r2){
        long a1 = time - (time/r1);
        long a2 = time - (time/r2);
        long lcm = lcm(r1, r2);
        long cf = time/lcm;
        long a3 = time - (time/r1 + time/r2 - cf);
        long d3 = a1 + a2 - a3;
        return (d1 <= a1 && d2 <= a2 && d1 + d2 <= d3);
    }

    // lcm()
    long lcm(long r1, long r2){
        long ans = 1;
        long divisor = 2;
        while(r1 > 1 || r2 > 1){

            while(r1 % divisor == 0 || r2 % divisor == 0){
                ans *= divisor;
                 if(r1 % divisor == 0){
                    r1 = r1/divisor;
                 }
                 if(r2 % divisor == 0){
                    r2 = r2/divisor;
                 }
            }
            divisor++;
        }
        return ans;
    }
}