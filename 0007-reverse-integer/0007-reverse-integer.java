class Solution {
    public int reverse(int x) {
        int sign;
        if(x >= 0){
            sign = 1;
        }else{
            sign = -1;
        }
       
        long ans = 0;
        int y = Math.abs(x);
        while(y > 0){
           int ld = y%10;
           ans = ans*10 + ld;
           if(sign*ans < Integer.MIN_VALUE || sign*ans > Integer.MAX_VALUE) return 0;
           y = y/10;
        }
        return (int)(sign*ans);
    }
}