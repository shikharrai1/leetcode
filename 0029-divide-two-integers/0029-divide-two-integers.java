class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign  = true; // +ve
        if(dividend >= 0 && divisor < 0 || dividend <= 0 && divisor > 0) sign = false;

       long n = Math.abs((long) dividend);
       long d = Math.abs((long) divisor);


        long ans = 0;
        while(n >= d){
          int count = 0;
          while(n >= d<<(count+1)){
            count++;
          }
          n -= (d<<count);
          ans += 1L<<count;
        }
        ans = sign ? ans : -ans;
        // 
        if(ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ans < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)ans;
    }
}