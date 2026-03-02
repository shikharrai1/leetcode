class Solution {
    public int myAtoi(String s) {
        // check if string is empty
        if(s.length() == 0 || s == null) return 0;
       
        int i = 0;
        int n = s.length();
         // remove whitespaces if present
        while(i<n && s.charAt(i) == ' '){
            i++;
        }

        if(i == n) return 0;

     int sign = 1;
     // determine sign if any
     if(s.charAt(i) == '+'){
        // sign = 1;
        i++;
     }else if(s.charAt(i) == '-'){
        sign = -1;
        i++;
     }
     // now traverse the string
     long ans = 0;
     while(i < n && Character.isDigit(s.charAt(i))){
        ans = ans*10 + s.charAt(i)-'0';

        // now check if ans is in the valid integer range
        if( sign*ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if( sign*ans < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        i++;
     }
     return (int)(ans*sign);
    }
}