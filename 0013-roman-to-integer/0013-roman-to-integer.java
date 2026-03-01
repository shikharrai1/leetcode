class Solution {
    public int romanToInt(String s) {
//-----------------App1(Brute Force)-------------------------------
        // HashMap<Character, Integer> map = new HashMap<>();
        // int ans = 0;
        // for(int i=0; i<s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(ch == 'I'){
        //         if(!map.containsKey(ch)){
        //             map.put(ch,1);
        //         }
        //     }else if(ch == 'V'){
        //         if(!map.containsKey(ch)){
        //             map.put(ch,5);
        //         }
        //     }else if(ch == 'X'){
        //         if(!map.containsKey(ch)){
        //             map.put(ch,10);
        //         }
        //     }else if(ch == 'L'){
        //         if(!map.containsKey(ch)){
        //             map.put(ch,50);
        //         }
        //     }else if(ch == 'C'){
        //         if(!map.containsKey(ch)){
        //             map.put(ch,100);
        //         }
        //     }else if(ch == 'D'){
        //         if(!map.containsKey(ch)){
        //             map.put(ch,500);
        //         }
        //     }else{
        //         if(!map.containsKey(ch)){
        //             map.put(ch,1000);
        //         }
        //     }
        // }

        // for(int i=0; i<s.length(); i++){
        //     char first = s.charAt(i);
        //     int val1 = map.get(first);
            
        //     if( i+1 < s.length() ){
        //         char second = s.charAt(i+1);
        //         int val2 = map.get(second);
        //         if(val1 >= val2){
        //             ans += val1;
        //         }else{
        //             ans += val2-val1;
        //             i++;
        //         }
                
        //     }else{
        //         ans += val1;
        //     }
        // }
        // return ans;
//-----------------------Optimal Sol------------------------------
int total = 0;
 for(int i=0; i<s.length(); i++){
     int currentVal = getVal(s.charAt(i));

     if( i+1 < s.length() && getVal(s.charAt(i+1)) > currentVal){
        total -= currentVal;
     }else{
        total += currentVal;
     }
 }
 return total;
    }

    // function getVal()
    int getVal(char ch){
        switch(ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}