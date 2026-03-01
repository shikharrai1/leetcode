class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'I'){
                if(!map.containsKey(ch)){
                    map.put(ch,1);
                }
            }else if(ch == 'V'){
                if(!map.containsKey(ch)){
                    map.put(ch,5);
                }
            }else if(ch == 'X'){
                if(!map.containsKey(ch)){
                    map.put(ch,10);
                }
            }else if(ch == 'L'){
                if(!map.containsKey(ch)){
                    map.put(ch,50);
                }
            }else if(ch == 'C'){
                if(!map.containsKey(ch)){
                    map.put(ch,100);
                }
            }else if(ch == 'D'){
                if(!map.containsKey(ch)){
                    map.put(ch,500);
                }
            }else{
                if(!map.containsKey(ch)){
                    map.put(ch,1000);
                }
            }
        }

        for(int i=0; i<s.length(); i++){
            char first = s.charAt(i);
            int val1 = map.get(first);
            
            if( i+1 < s.length() ){
                char second = s.charAt(i+1);
                int val2 = map.get(second);
                if(val1 >= val2){
                    ans += val1;
                }else{
                    ans += val2-val1;
                    i++;
                }
                
            }else{
                ans += val1;
            }
        }
        return ans;
    }
}