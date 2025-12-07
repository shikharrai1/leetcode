class Solution {
    public boolean completePrime(int num) {
        if(num <= 9){
            return isPrime(num);
        }
        String s = String.valueOf(num);
        for(int i=1; i<=s.length(); i++){
            String pre = s.substring(0,i);
             int prefix =  Integer.parseInt(pre);
          
             boolean ans = isPrime(prefix);
            if(!ans) return false;
            
        }
        for(int i=0; i<=s.length(); i++){
            String suff = s.substring(i);
            int suffix = (suff == "") ? 0 : Integer.parseInt(suff);
           if(suffix > 0){
                    boolean ans = isPrime(suffix);
            if(!ans) return false;
           }
        }
        return true;
    }
    // isPrime()
    boolean isPrime(int num){
        int cnt = 0;
        for(int i=1; i*i <= num; i++){
            if(num % i == 0){
                cnt++;
                if(num/i != i){
                    cnt++;
                }
            }
        }
        return cnt==2;
    }
}