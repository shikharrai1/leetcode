class Solution {
    private static final long mod = 1000000007;
    public int countGoodNumbers(long n) {
       
        long evenCount = (n+1)/2;
        long oddCount = n/2;
          
          // 
        long ans1 = Power((long)5,evenCount); // even position choices
        long ans2 = Power((long)4,oddCount); // odd position choices
         return (int)((ans1*ans2)%mod);
    }

    public long Power(long x, long n){ // x^n
        if(n == 0) return 1;
            
        long half = Power(x,n/2)%mod;
        long halfSq = (half*half)%mod;

        if(n % 2 == 0){
            return halfSq;
        }else{
            return (x%mod * halfSq)%mod;
        }
    }
}