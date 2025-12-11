class Solution {
    public int largestPrime(int n) {
        int sum = 0;
        int lastPrime = 2;
        for(int p = 2; sum<=n; p++){
            if(isPrime(p)){
                sum += p;
                if(sum > n) break;

                if(isPrime(sum)){
                    lastPrime = sum;
                }
            }
        }
        return (isPrime(lastPrime) && lastPrime <= n) ? lastPrime : 0;
    }
    boolean isPrime(int x){
        int cnt = 0;
        for(int i = 1; i*i <= x; i++){
            if(x%i == 0){
                cnt++;
                if(x/i != i) cnt++;
            }
        }
        return cnt == 2;
    }
}